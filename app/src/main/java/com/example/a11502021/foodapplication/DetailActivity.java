package com.example.a11502021.foodapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a11502021.foodapplication.database.DatabaseHelper;
import com.example.a11502021.foodapplication.fragments.DetailsFragment;
import com.example.a11502021.foodapplication.models.Hit;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends FragmentActivity {

    Button addToFavorites;
    private DatabaseHelper dbHelper;
    private Hit hit;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favorites_detail);

        addToFavorites = (Button) findViewById(R.id.detailfrag_add_to_favourites);

        Intent intent = getIntent();
        hit = new Gson().fromJson(intent.getExtras().getString("hit"), Hit.class);
        boolean showAddToFavorites = intent.getExtras().getBoolean("showAddToFavorites");

        if (showAddToFavorites) {
            dbHelper = new DatabaseHelper(this);
            addToFavorites.setVisibility(View.VISIBLE);

            addToFavorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean insertHit = dbHelper.addData(hit);
                    if (insertHit) {
                        Toast.makeText(DetailActivity.this, "Added " + hit.getRecipe().getLabel() + " to favorites.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error adding to favorites.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        updateValues(hit);

    }

    @SuppressLint("SetTextI18n")
    private void updateValues(Hit hit) {
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
