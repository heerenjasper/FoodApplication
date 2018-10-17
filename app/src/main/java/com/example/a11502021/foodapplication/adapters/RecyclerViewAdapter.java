package com.example.a11502021.foodapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.example.a11502021.foodapplication.R;
import com.example.a11502021.foodapplication.models.Hit;

import java.util.ArrayList;

/**
 * Created by 11502021 on 8/10/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Hit> mHits = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<Hit> mHits, Context mContext) {
        this.mHits = mHits;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext)
                .asBitmap()
                .load(mHits.get(i).getRecipe().getImage())
                .into(viewHolder.image);
        viewHolder.recipeName.setText(mHits.get(i).getRecipe().getLabel());
        viewHolder.caloriesCount.setText(Math.round(mHits.get(i).getRecipe().getCalories().intValue() /
        mHits.get(i).getRecipe().getYield()) + " cal");

        viewHolder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(viewHolder.overflow);
            }
        });

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //later to be replaced by logic to go into recipe details
                Log.d(TAG, "onClick: Clicked on " + mHits.get(i).getRecipe().getLabel());
                Toast.makeText(mContext, mHits.get(i).getRecipe().getLabel(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourites", Toast.LENGTH_SHORT).show();
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
