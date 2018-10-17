package com.example.a11502021.foodapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.a11502021.foodapplication.adapters.RecipesStatePagerAdapter;
import com.example.a11502021.foodapplication.api.HitsController;
import com.example.a11502021.foodapplication.fragments.DetailsFragment;
import com.example.a11502021.foodapplication.fragments.MainFragment;

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
        // setup the pager
        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewpager) {
        RecipesStatePagerAdapter adapter = new RecipesStatePagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new MainFragment(), "Main");
        adapter.AddFragment(new DetailsFragment(), "Details");
        //adapter.AddFragment(new ???Fragment(), "Details");
        //adapter.AddFragment(new ???Fragment(), "Some Other Thing");
        viewpager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentIndex) {
        mViewPager.setCurrentItem(fragmentIndex);
    }

}
