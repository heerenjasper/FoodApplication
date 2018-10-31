package com.example.a11502021.foodapplication.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a11502021.foodapplication.R;
import com.example.a11502021.foodapplication.database.DatabaseHelper;
import com.example.a11502021.foodapplication.models.Hit;
import com.example.a11502021.foodapplication.models.Recipe;
import com.google.gson.Gson;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 11502021 on 17/10/2018.
 */

public class DetailsFragment extends Fragment {

    private static final String TAG = "Details Fragment";
    private View mView;
    private CircleImageView image;
    private Button addToFavourites;
    private TextView recipeLabel, caloriesCount, publisher, servings;
    private Hit currentHit;
    private DatabaseHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: Details Fragment Started.");

        mView = inflater.inflate(R.layout.detailsfragment_layout, container, false);
        image = (CircleImageView) mView.findViewById(R.id.detailfrag_image);
        recipeLabel = (TextView) mView.findViewById(R.id.detailfrag_recipe_name);
        addToFavourites = (Button) mView.findViewById(R.id.detailfrag_add_to_favourites);
        caloriesCount = (TextView) mView.findViewById(R.id.detailfrag_cal);
        publisher = (TextView) mView.findViewById(R.id.detailfrag_publisher);
        servings = (TextView) mView.findViewById(R.id.detailfrag_servings);

        Bundle bundle = getArguments();

        if(bundle != null){
            currentHit = new Gson().fromJson(getArguments().getString("hit"), Hit.class);

            updateValues(currentHit);

            dbHelper = new DatabaseHelper(this.getContext());

            addToFavourites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean insertHit = dbHelper.addData(currentHit);
                    if (insertHit) {
                        Toast.makeText(getContext(), "Added " + currentHit.getRecipe().getLabel() + " to favorites.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Error adding to favorites.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        return mView;
    }

    @SuppressLint("SetTextI18n")
    public void updateValues(Hit hit) {
            Glide.with(getContext())
                    .asBitmap()
                    .load(hit.getRecipe().getImage())
                    .into(this.image);
            this.recipeLabel.setText(hit.getRecipe().getLabel());
            this.caloriesCount.setText(Math.round(hit.getRecipe().getCalories().intValue() /
                    hit.getRecipe().getYield()) + "");
            this.publisher.setText(hit.getRecipe().getSource());
            this.servings.setText(hit.getRecipe().getYield().toString());
    }

}
