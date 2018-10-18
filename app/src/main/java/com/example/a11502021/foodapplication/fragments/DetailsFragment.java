package com.example.a11502021.foodapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.button.MaterialButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a11502021.foodapplication.R;

/**
 * Created by 11502021 on 17/10/2018.
 */

public class DetailsFragment extends Fragment {

    private static final String TAG = "Details Fragment";
    private View mView;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: onCreateView.");

        mView = inflater.inflate(R.layout.detailsfragment_layout, container, false);
        //button = (Button) mView.findViewById(R.id.testbutton);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked");
            }
        });*/

        return mView;
    }

}
