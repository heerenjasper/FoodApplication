package com.example.a11502021.foodapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a11502021.foodapplication.adapters.RecipesStatePagerAdapter;
import com.example.a11502021.foodapplication.fragments.DetailsFragment;
import com.example.a11502021.foodapplication.fragments.MainFragment;
import com.example.a11502021.foodapplication.models.Hit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecipesStatePagerAdapter mRecipesStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mRecipesStatePagerAdapter = new RecipesStatePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewpager) {
        RecipesStatePagerAdapter adapter = new RecipesStatePagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new MainFragment(), "Main");
        adapter.AddFragment(new DetailsFragment(), "Details");
        viewpager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentIndex, Hit hit) {
        mViewPager.setCurrentItem(fragmentIndex);
    }

}
