package com.example.a11502021.foodapplication.fragments;

import android.annotation.SuppressLint;
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

import com.bumptech.glide.Glide;
import com.example.a11502021.foodapplication.R;
import com.example.a11502021.foodapplication.models.Hit;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 11502021 on 17/10/2018.
 */

public class DetailsFragment extends Fragment {

    private static final String TAG = "Details Fragment";
    private View mView;
    private CircleImageView image;
    private Button addToFavourites;
    private TextView recipeLabel, caloriesCount, dailyValue, servings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: Details Fragment Started.");

        mView = inflater.inflate(R.layout.detailsfragment_layout, container, false);
        image = (CircleImageView) mView.findViewById(R.id.detailfrag_image);
        recipeLabel = (TextView) mView.findViewById(R.id.detailfrag_recipe_name);
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

    @SuppressLint("SetTextI18n")
    public void updateValues(Hit hit) {
        if (getContext() != null) {
            Glide.with(getContext())
                    .asBitmap()
                    .load(hit.getRecipe().getImage())
                    .into(image);
        }
        recipeLabel.setText(hit.getRecipe().getLabel());
        caloriesCount.setText(Math.round(hit.getRecipe().getCalories().intValue() /
                hit.getRecipe().getYield()) + "");
        //dailyValue.setText(hit.getRecipe().getTotalDaily().getPROCNT().getLabel());
        servings.setText(hit.getRecipe().getYield().toString());
    }

}
