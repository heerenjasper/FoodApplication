package com.example.a11502021.foodapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a11502021.foodapplication.database.DatabaseHelper;
import com.example.a11502021.foodapplication.models.Hit;
import com.google.gson.Gson;

public class DetailActivity extends FragmentActivity {

    Button addToFavorites, instructions;
    private DatabaseHelper dbHelper;
    private Hit hit;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favorites_detail);

        addToFavorites = (Button) findViewById(R.id.detailfrag_add_to_favourites);
        instructions = (Button) findViewById(R.id.detailfrag_instructions);

        Intent intent = getIntent();
        hit = new Gson().fromJson(intent.getExtras().getString("hit"), Hit.class);
        boolean clickable = intent.getExtras().getBoolean("clickable");

        if (clickable) {
            dbHelper = new DatabaseHelper(this);
            addToFavorites.setClickable(true);
            addToFavorites.setBackgroundResource(R.drawable.buttonstyle);

            addToFavorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean insertHit = dbHelper.addData(hit);
                    if (insertHit) {
                        Toast.makeText(DetailActivity.this, "Added " + hit.getRecipe().getLabel() + " to favorites.", Toast.LENGTH_SHORT).show();
                        addToFavorites.setClickable(false);
                        addToFavorites.setBackgroundResource(R.drawable.buttonstyle_disabled);
                    } else {
                        Toast.makeText(DetailActivity.this, "Error adding to favorites.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveToWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(hit.getRecipe().getUrl()));
                startActivity(moveToWebsite);
            }
        });

        updateValues(hit);

    }

    @SuppressLint("SetTextI18n")
    private void updateValues(Hit hit) {
        Glide.with(this)
                .asBitmap()
                .load(hit.getRecipe().getImage())
                .into((ImageView) findViewById(R.id.detailfrag_image));
        ((TextView) findViewById(R.id.detailfrag_recipe_name)).setText(hit.getRecipe().getLabel());
        ((TextView) findViewById(R.id.detailfrag_cal)).setText(Math.round(hit.getRecipe().getCalories().intValue() /
                hit.getRecipe().getYield()) + "");
        ((TextView) findViewById(R.id.detailfrag_publisher)).setText(hit.getRecipe().getSource());
        ((TextView) findViewById(R.id.detailfrag_servings)).setText(hit.getRecipe().getYield().toString());
        ((TextView) findViewById(R.id.detailfrag_amount_ingredients)).setText(hit.getRecipe().getIngredientLines().size() + " Ingredients");
        StringBuilder ingredients = new StringBuilder();
        for (String item : hit.getRecipe().getIngredientLines()) {
            ingredients.append(item).append("\n\n");
        }
        ((TextView) findViewById(R.id.detailfrag_all_ingredients)).setText(ingredients);
    }
}
