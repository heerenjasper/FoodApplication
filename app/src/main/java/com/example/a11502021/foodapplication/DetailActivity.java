package com.example.a11502021.foodapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.a11502021.foodapplication.fragments.DetailsFragment;
import com.example.a11502021.foodapplication.models.Hit;
import com.google.gson.Gson;

public class DetailActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favorites_detail);

        Intent intent = getIntent();
        Hit hit = new Gson().fromJson(intent.getExtras().getString("hit"), Hit.class);

        // change values of fragment here with getviewbyid. -- use hit.


    }

}
