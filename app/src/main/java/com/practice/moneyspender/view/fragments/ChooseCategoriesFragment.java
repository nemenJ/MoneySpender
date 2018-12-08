package com.practice.moneyspender.view.fragments;


import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.practice.moneyspender.R;
import com.practice.moneyspender.database.App;
import com.practice.moneyspender.database.AppDataBase;
import com.practice.moneyspender.database.CategoriesDao;
import com.practice.moneyspender.database.CategoriesDatabase;
import com.practice.moneyspender.database.DatabaseInit;

import java.util.List;

public class ChooseCategoriesFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        //Adding toolbar and back to CostChooser
        View view = inflater.inflate(R.layout.choose_categories_list, container, false);
        Toolbar toolbar = view.findViewById(R.id.choose_categories_toolbar);

        TextView circleWord = view.findViewById(R.id.circle_category_name);
        TextView categoryName = view.findViewById(R.id.category_name);






        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();

            }
        });




        // Inflate the layout for this fragment
        return view;
    }

}
