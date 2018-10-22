package com.example.a11502021.foodapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.button.MaterialButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a11502021.foodapplication.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 11502021 on 17/10/2018.
 */

public class DetailsFragment extends Fragment {

    private static final String TAG = "Details Fragment";
    private View mView;
    private CircleImageView image;
    private Button addToFavourites;
    private TextView caloriesCount, dailyValue, servings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: Details Fragment Started.");

        mView = inflater.inflate(R.layout.detailsfragment_layout, container, false);
        image = (CircleImageView) mView.findViewById(R.id.detailfrag_image);
        addToFavourites = (Button) mView.findViewById(R.id.detailfrag_add_to_favourites);
        caloriesCount = (TextView) mView.findViewById(R.id.detailfrag_cal);
        dailyValue = (TextView) mView.findViewById(R.id.detailfrag_daily_value);
        servings = (TextView) mView.findViewById(R.id.detailfrag_servings);

        addToFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Add to favourites", Toast.LENGTH_SHORT).show();
            }
        });

        return mView;
    }

}
