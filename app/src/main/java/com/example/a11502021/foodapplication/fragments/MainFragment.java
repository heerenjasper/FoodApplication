package com.example.a11502021.foodapplication.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.a11502021.foodapplication.FavoritesActivity;
import com.example.a11502021.foodapplication.R;
import com.example.a11502021.foodapplication.adapters.RecipeRecyclerViewAdapter;
import com.example.a11502021.foodapplication.api.Api;
import com.example.a11502021.foodapplication.fragments.decoration.GridSpacingItemDecoration;
import com.example.a11502021.foodapplication.models.Example;
import com.example.a11502021.foodapplication.models.Hit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 11502021 on 8/10/2018.
 */

public class MainFragment extends Fragment {
    private static final String TAG = "Main Fragment";

    // controls declaration here
    private ArrayList<Hit> mHits = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecipeRecyclerViewAdapter mAdapter;
    private View mView;
    private EditText searchText;
    private Button searchButton, favoritesButton;
    RelativeLayout loadingPanel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: Main Fragment Started.");

        mView = inflater.inflate(R.layout.mainfragment_layout, container, false);
        searchText = (EditText) mView.findViewById(R.id.search_text);
        searchButton = (Button) mView.findViewById(R.id.search_button);
        favoritesButton = (Button) mView.findViewById(R.id.favorites_button);
        loadingPanel = (RelativeLayout) mView.findViewById(R.id.loadingPanel);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerView.setVisibility(View.GONE);
                loadingPanel.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    public void run() {
                        ApiGetByKeyword(searchText.getText().toString());
                    }
                }).start();
            }
        });

        favoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FavoritesActivity.class);
                startActivity(intent);
            }
        });

        initRecyclerView();

        return mView;
    }

    public void ApiGetByKeyword(String keyword) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<Example> call = api.getHits(keyword, Api.APP_ID, Api.APP_KEY);

        //the enqueue is async
        call.enqueue(new Callback<Example>() {

            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                initHits(response.body());
                mRecyclerView.setVisibility(View.VISIBLE);
                loadingPanel.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                loadingPanel.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error connecting to API.", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure: the call failed.");
                Log.d(TAG, t.getMessage());
            }

        });
    }

    private void initHits(Example hits) {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mHits.clear();

        if (hits.getCount() != 0) {
            mHits.addAll(hits.getHits());
        } else {
            Toast.makeText(getContext(), "No results were found.", Toast.LENGTH_SHORT).show();
        }

        updateRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init Recyclerview.");
        mRecyclerView = mView.findViewById(R.id.recyclerv_view);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 10, true, getResources()));
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new RecipeRecyclerViewAdapter(mHits, getActivity());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void updateRecyclerView() {
        mAdapter.notifyDataSetChanged();
    }

}
