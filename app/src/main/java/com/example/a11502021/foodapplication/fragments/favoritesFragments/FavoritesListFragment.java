 // TODO 1. CREATE NEW ACTIVITY AND EXTEND FROM FRAGMENT

package com.example.a11502021.foodapplication.fragments.favoritesFragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.a11502021.foodapplication.FavoritesDetailActivity;
import com.example.a11502021.foodapplication.R;
import com.example.a11502021.foodapplication.adapters.FavoritesListAdapter;
import com.example.a11502021.foodapplication.database.DatabaseHelper;
import com.example.a11502021.foodapplication.database.RecipeContract;
import com.example.a11502021.foodapplication.models.Hit;
import com.example.a11502021.foodapplication.models.Recipe;

import java.util.ArrayList;
import java.util.List;

 public class FavoritesListFragment extends Fragment {

     //LIST OF ARRAY HITS WHICH WILL SERVE AS LIST ITEMS
     ArrayList<Hit> listItems = new ArrayList<>();

     //DEFINING A HIT ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
     FavoritesListAdapter adapter;

     private DatabaseHelper dbHelper;
     SwipeMenuListView listView;

    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.activity_favorites_list_fragment, container, false);

         return view;
     }

     @Override
     public void onActivityCreated(@Nullable Bundle savedInstanceState) {
         super.onActivityCreated(savedInstanceState);

         listView = (SwipeMenuListView) getView().findViewById(R.id.favorites_listView);
         adapter = new FavoritesListAdapter(getContext(), R.layout.favorites_adapterview_layout, listItems);
         listView.setAdapter(adapter);

         dbHelper = new DatabaseHelper(this.getContext());

         SwipeMenuCreator creator = new SwipeMenuCreator() {

             @Override
             public void create(SwipeMenu menu) {
                 SwipeMenuItem deleteItem = new SwipeMenuItem(
                         getContext());
                 deleteItem.setWidth(250);
                 deleteItem.setIcon(R.drawable.ic_delete);
                 menu.addMenuItem(deleteItem);
             }
         };

         listView.setMenuCreator(creator);

         listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
             @Override
             public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                 Toast.makeText(getContext(), "Deleted " + listItems.get(position).getRecipe().getLabel() + " from favorites.", Toast.LENGTH_SHORT).show();
                 return false;
             }
         });

         getAllFavorites();

         /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 String item = (String)listView.getItemAtPosition(i);
                 Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();

                 FavoritesDetailFragment favoritesDetailFragment = (FavoritesDetailFragment) getFragmentManager().findFragmentById(R.id.favorites_detail);
                 if (favoritesDetailFragment != null && favoritesDetailFragment.isVisible()) {
                     // Visible: send bundle
                     FavoritesDetailFragment newFragment = new FavoritesDetailFragment();
                     Bundle bundle = new Bundle();
                     bundle.putString("item", item);
                     newFragment.setArguments(bundle);

                     FragmentTransaction transaction = getFragmentManager().beginTransaction();
                     transaction.replace(favoritesDetailFragment.getId(), newFragment);
                     transaction.addToBackStack(null);

                     // Commit the transaction
                     transaction.commit();
                 }
                 else {
                     // Not visible: start as intent
                     Intent intent = new Intent(getActivity().getBaseContext(), FavoritesDetailActivity.class);
                     intent.putExtra("item", item);
                     getActivity().startActivity(intent);
                 }

             }
         });*/
     }

     public void updateList() {
         adapter.notifyDataSetChanged();
     }

     private void getAllFavorites() {
        Cursor data = dbHelper.getData();
        while (data.moveToNext()) {
            Recipe recipe = new Recipe();
            recipe.setLabel(data.getString(data.getColumnIndex(RecipeContract.RecipeEntry.LABEL)));
            recipe.setImage(data.getString(data.getColumnIndex(RecipeContract.RecipeEntry.IMAGE)));
            recipe.setCalories(data.getDouble(data.getColumnIndex(RecipeContract.RecipeEntry.CALORIES)));
            recipe.setSource(data.getString(data.getColumnIndex(RecipeContract.RecipeEntry.PUBLISHER)));
            recipe.setYield(data.getInt(data.getColumnIndex(RecipeContract.RecipeEntry.SERVINGS)));

            Hit hit = new Hit();
            hit.setRecipe(recipe);

            listItems.add(hit);
         }
         updateList();
     }

 }

