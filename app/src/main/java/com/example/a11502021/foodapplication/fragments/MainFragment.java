package com.example.a11502021.foodapplication.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a11502021.foodapplication.R;
import com.example.a11502021.foodapplication.adapters.RecyclerViewAdapter;
import com.example.a11502021.foodapplication.api.Api;
import com.example.a11502021.foodapplication.api.HitsController;
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
    RecyclerViewAdapter mAdapter;
    private View mView;
    private EditText searchText;
    private Button searchButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: onCreateView.");

        mView = inflater.inflate(R.layout.mainfragment_layout, container, false);
        searchText = (EditText) mView.findViewById(R.id.search_text);
        searchButton = (Button) mView.findViewById(R.id.search_button);
        searchButton.setText("Search");

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHits.clear();
                updateRecyclerView();
                new Thread(new Runnable() {
                    public void run() {
                        ApiGetByKeyword(searchText.getText().toString());
                    }
                }).start();
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
                HitsController.setHits(response.body());
                initImageBitmaps(HitsController.getHits());
                Log.d(TAG, "onResponse: " + HitsController.getHits().getCount());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d(TAG, "onFailure: the call failed.");
                Log.d(TAG, t.getMessage());
            }

        });
    }

    private void initImageBitmaps(Example hits) {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        if (hits.getCount() != 0) {
            mHits.addAll(hits.getHits());
        } else {
            Toast.makeText(getContext(), "No results were found.", Toast.LENGTH_SHORT).show();
        }

        updateRecyclerView();
    }

    private void updateRecyclerView() {
        mAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init Recyclerview.");
        mRecyclerView = mView.findViewById(R.id.recyclerv_view);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new RecyclerViewAdapter(mHits, getActivity());
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
