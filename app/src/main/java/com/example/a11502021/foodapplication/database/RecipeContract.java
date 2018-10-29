package com.example.a11502021.foodapplication.database;

import android.provider.BaseColumns;

/**
 * Created by 11502021 on 26/10/2018.
 */

public final class RecipeContract {

    private static final String TAG = "RecipeContract";

    private RecipeContract() {}

    public static class RecipeEntry implements BaseColumns {

        public static final String TABLE_NAME = "favorites";
        public static final String LABEL = "label";
        public static final String IMAGE = "imageURL";
        public static final String PUBLISHER = "publisher";
        public static final String CALORIES = "calories";
        public static final String SERVINGS = "servings";

    }

}
