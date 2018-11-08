package com.example.a11502021.foodapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a11502021.foodapplication.R;
import com.example.a11502021.foodapplication.models.Hit;

import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 11502021 on 30/10/2018.
 */

public class FavoritesListAdapter extends ArrayAdapter<Hit> {

    private static final String TAG = "FavoritesListAdapter";

    private Context mContext;
    private int mResource;
    public ArrayList<Hit> mHits = new ArrayList<>();

    public FavoritesListAdapter(@NonNull Context context, int resource, ArrayList<Hit> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        mHits = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String imageUrl = getItem(position).getRecipe().getImage();
        String label = getItem(position).getRecipe().getLabel();
        String publisher = getItem(position).getRecipe().getSource();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        CircleImageView cvImage = (CircleImageView) convertView.findViewById(R.id.cvImage);
        TextView tvLabel = (TextView) convertView.findViewById(R.id.tvLabel);
        TextView tvPublisher = (TextView) convertView.findViewById(R.id.tvPublisher);

        Glide.with(getContext())
                .asBitmap()
                .load(imageUrl)
                .into(cvImage);
        tvLabel.setText(label);
        tvPublisher.setText(publisher);

        return convertView;
    }

    public int getItemCount() {
        return mHits.size();
    }

    @Override
    public void remove(Hit hit) {
        this.mHits.remove(hit);
    }

}
