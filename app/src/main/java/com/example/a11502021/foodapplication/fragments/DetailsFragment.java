package com.example.a11502021.foodapplication.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a11502021.foodapplication.R;
import com.example.a11502021.foodapplication.models.Hit;
import com.google.gson.Gson;

/**
 * Created by 11502021 on 17/10/2018.
 */

public class DetailsFragment extends Fragment {

    private static final String TAG = "Details Fragment";
    private View mView;
    private ImageView image;
    private TextView recipeLabel, caloriesCount, publisher, servings, ingredientAmount, ingredients;
    private Hit currentHit;
    private Button instructions;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: Details Fragment Started.");

        mView = inflater.inflate(R.layout.detailsfragment_layout, container, false);
        image = (ImageView) mView.findViewById(R.id.detailfrag_image);
        recipeLabel = (TextView) mView.findViewById(R.id.detailfrag_recipe_name);
        caloriesCount = (TextView) mView.findViewById(R.id.detailfrag_cal);
        publisher = (TextView) mView.findViewById(R.id.detailfrag_publisher);
        servings = (TextView) mView.findViewById(R.id.detailfrag_servings);
        ingredientAmount = (TextView) mView.findViewById(R.id.detailfrag_amount_ingredients);
        ingredients = (TextView) mView.findViewById(R.id.detailfrag_all_ingredients);
        instructions = (Button) mView.findViewById(R.id.detailfrag_instructions);

        Bundle bundle = getArguments();

        if(bundle != null){
            currentHit = new Gson().fromJson(getArguments().getString("hit"), Hit.class);

            updateValues(currentHit);

            instructions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent moveToWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(currentHit.getRecipe().getUrl()));
                    startActivity(moveToWebsite);
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
            this.ingredientAmount.setText(hit.getRecipe().getIngredientLines().size() + " ingredients");
            StringBuilder ingredients = new StringBuilder();
            for (String item : hit.getRecipe().getIngredientLines()) {
                ingredients.append(item).append("\n\n");
            }
            this.ingredients.setText(ingredients);
    }

}
