package com.example.a11502021.foodapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a11502021.foodapplication.fragments.DetailsFragment;
import com.example.a11502021.foodapplication.models.Hit;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends FragmentActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favorites_detail);

        Intent intent = getIntent();
        Hit hit = new Gson().fromJson(intent.getExtras().getString("hit"), Hit.class);

        Glide.with(this)
                .asBitmap()
                .load(hit.getRecipe().getImage())
                .into((CircleImageView) findViewById(R.id.detailfrag_image));
        ((TextView) findViewById(R.id.detailfrag_recipe_name)).setText(hit.getRecipe().getLabel());
        ((TextView) findViewById(R.id.detailfrag_cal)).setText(Math.round(hit.getRecipe().getCalories().intValue() /
                hit.getRecipe().getYield()) + "");
        ((TextView) findViewById(R.id.detailfrag_publisher)).setText(hit.getRecipe().getSource());
        ((TextView) findViewById(R.id.detailfrag_servings)).setText(hit.getRecipe().getYield().toString());

    }

}
