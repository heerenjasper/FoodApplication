package com.example.a11502021.foodapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a11502021.foodapplication.DetailActivity;
import com.example.a11502021.foodapplication.R;
import com.example.a11502021.foodapplication.database.DatabaseHelper;
import com.example.a11502021.foodapplication.models.Hit;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by 11502021 on 8/10/2018.
 */

public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeCardViewHolder>{

    private static final String TAG = "RecipeRecyclerViewAdapter";

    private ArrayList<Hit> mHits = new ArrayList<>();
    private Context mContext;
    private DatabaseHelper dbHelper;

    public RecipeRecyclerViewAdapter(ArrayList<Hit> mHits, Context mContext) {
        this.mHits = mHits;
        this.mContext = mContext;
        dbHelper = new DatabaseHelper(mContext);
    }

    @NonNull
    @Override
    public RecipeCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        return new RecipeCardViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final RecipeCardViewHolder recipeCardViewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext)
                .asBitmap()
                .load(mHits.get(i).getRecipe().getImage())
                .into(recipeCardViewHolder.image);
        recipeCardViewHolder.recipeName.setText(mHits.get(i).getRecipe().getLabel());
        recipeCardViewHolder.caloriesCount.setText((mHits.get(i).getRecipe().getCalories().intValue() /
        mHits.get(i).getRecipe().getYield()) + " cal");

        recipeCardViewHolder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(recipeCardViewHolder.overflow, mHits.get(i));
            }
        });

        recipeCardViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked on " + mHits.get(i).getRecipe().getLabel());
/*
                MainActivity mainActivity = (MainActivity) mContext;
                DetailsFragment detailsFragment;
                //detailsFragment = (DetailsFragment) mainActivity.getmStatePagerAdapter().getItem(1);
                detailsFragment = (DetailsFragment) mainActivity.getFragmentManager().findFragmentById(R.id.favorites_detail);
                detailsFragment.updateValues(mHits.get(i));
                mainActivity.setViewPager(1);*/

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("hit", (new Gson()).toJson(mHits.get(i)));
                //intent.putExtra("label", mHits.get(i).getRecipe().getLabel());
               //intent.putExtra("image", mHits.get(i).getRecipe().getImage());
                //intent.putExtra("publisher", mHits.get(i).getRecipe().getSource());
                //intent.putExtra("calories", (mHits.get(i).getRecipe().getCalories().intValue() / mHits.get(i).getRecipe().getYield()) + "");
                //intent.putExtra("servings", mHits.get(i).getRecipe().getYield().toString());
                mContext.startActivity(intent);
            }
        });
    }

    private void showPopupMenu(View view, Hit currentHit) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(currentHit));
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        private Hit currentHit;

        MyMenuItemClickListener(Hit hit) {
            this.currentHit = hit;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    boolean insertHit = dbHelper.addData(currentHit);
                    if (insertHit) {
                        Toast.makeText(mContext, "Added " + currentHit.getRecipe().getLabel() + " to favorites.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, "Error adding to favorites.", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return mHits.size();
    }

}
