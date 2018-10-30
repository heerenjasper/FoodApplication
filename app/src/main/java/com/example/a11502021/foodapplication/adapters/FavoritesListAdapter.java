package com.example.a11502021.foodapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a11502021.foodapplication.R;
import com.example.a11502021.foodapplication.models.Hit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 11502021 on 30/10/2018.
 */

public class FavoritesListAdapter extends ArrayAdapter<Hit> {

    private static final String TAG = "FavoritesListAdapter";

    private Context mContext;
    private int mResource;

    public FavoritesListAdapter(@NonNull Context context, int resource, ArrayList<Hit> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String label = getItem(position).getRecipe().getLabel();
        String publisher = getItem(position).getRecipe().getSource();
        String calories = (getItem(position).getRecipe().getCalories().intValue() / getItem(position).getRecipe().getYield()) + "";

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvLabel = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvPublisher = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvCalories = (TextView) convertView.findViewById(R.id.textView3);

        tvLabel.setText(label);
        tvPublisher.setText(publisher);
        tvCalories.setText(calories);

        return convertView;
    }
}
