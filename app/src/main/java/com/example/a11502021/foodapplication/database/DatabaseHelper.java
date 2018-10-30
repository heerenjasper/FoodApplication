package com.example.a11502021.foodapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.a11502021.foodapplication.models.Hit;

/**
 * Created by 11502021 on 26/10/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String DB_NAME = "favorites";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_FAVORITES_TABLE = "CREATE TABLE " + RecipeContract.RecipeEntry.TABLE_NAME + " (" +
                RecipeContract.RecipeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                RecipeContract.RecipeEntry.LABEL + " TEXT NOT NULL, " +
                RecipeContract.RecipeEntry.IMAGE + " TEXT NOT NULL, " +
                RecipeContract.RecipeEntry.PUBLISHER + " TEXT NOT NULL, " +
                RecipeContract.RecipeEntry.CALORIES + " REAL NOT NULL, " +
                RecipeContract.RecipeEntry.SERVINGS + " INTEGER NOT NULL" +
                ");";

        sqLiteDatabase.execSQL(SQL_CREATE_FAVORITES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RecipeContract.RecipeEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + RecipeContract.RecipeEntry.TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public boolean addData(Hit hit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(RecipeContract.RecipeEntry.LABEL, hit.getRecipe().getLabel());
        contentValues.put(RecipeContract.RecipeEntry.IMAGE, hit.getRecipe().getImage());
        contentValues.put(RecipeContract.RecipeEntry.PUBLISHER, hit.getRecipe().getSource());
        contentValues.put(RecipeContract.RecipeEntry.CALORIES, hit.getRecipe().getCalories());
        contentValues.put(RecipeContract.RecipeEntry.SERVINGS, hit.getRecipe().getYield());

        Log.d(TAG, "addData: " + "Adding " + hit.getRecipe().getLabel() + " to " + RecipeContract.RecipeEntry.TABLE_NAME);

        long result = db.insert(RecipeContract.RecipeEntry.TABLE_NAME, null, contentValues);

       /* if (result == -1) {
            return false;
        } else {
            return true;
        }*/

       return result != -1;
    }
}
