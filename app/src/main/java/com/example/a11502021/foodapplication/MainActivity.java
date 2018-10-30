package com.example.a11502021.foodapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a11502021.foodapplication.adapters.StatePagerAdapter;
import com.example.a11502021.foodapplication.fragments.DetailsFragment;
import com.example.a11502021.foodapplication.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private StatePagerAdapter mStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mStatePagerAdapter = new StatePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewpager) {
        StatePagerAdapter adapter = new StatePagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new MainFragment(), "Main");
        adapter.AddFragment(new DetailsFragment(), "Details");
        mStatePagerAdapter = adapter;
        viewpager.setAdapter(mStatePagerAdapter);
    }

    public void setViewPager(int fragmentIndex) {
        mViewPager.setCurrentItem(fragmentIndex);
    }

    public StatePagerAdapter getmStatePagerAdapter() {
        return this.mStatePagerAdapter;
    }

}
