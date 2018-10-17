package com.example.a11502021.foodapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a11502021.foodapplication.R;

/**
 * Created by 11502021 on 9/10/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    //CircleImageView image;
    ImageView image;
    ImageView overflow;
    TextView recipeName;
    TextView caloriesCount;
    RelativeLayout parentLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        overflow = itemView.findViewById(R.id.overflow);
        recipeName = itemView.findViewById(R.id.recipe_name);
        caloriesCount = itemView.findViewById(R.id.cal_count);
        parentLayout = itemView.findViewById(R.id.parent_layout);
    }

}
