package com.example.a11502021.foodapplication.fragments.favoritesFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.a11502021.foodapplication.R;

public class FavoritesDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_favorites_detail_fragment, container, false);

        Bundle bundle = getArguments();
        EditText editText = (EditText) view.findViewById(R.id.editTextItem);
        String item = "";

        if(bundle != null){
            item = getArguments().getString("item");
        }

        editText.setText(item);

        return view;
    }

}
