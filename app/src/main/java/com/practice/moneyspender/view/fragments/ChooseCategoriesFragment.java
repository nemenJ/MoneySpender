package com.practice.moneyspender.view.fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.practice.moneyspender.R;
import com.practice.moneyspender.adapters.CategoriesAdapter;
import com.practice.moneyspender.database.CategoriesDatabase;
import com.practice.moneyspender.database.CategoriesViewModel;

import java.util.List;

public class ChooseCategoriesFragment extends Fragment {


    private CategoriesViewModel ctView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        //Adding toolbar and back to CostChooser
        View view = inflater.inflate(R.layout.fragment_choose_categories, container, false);
        Toolbar toolbar = view.findViewById(R.id.choose_categories_toolbar);
        toolbar.setTitle(R.string.fragment_category);

        //adding 2 text views
        TextView circleWord = view.findViewById(R.id.circle_category_name);
        final TextView categoryName = view.findViewById(R.id.category_name);


        //adding recycler view and adapter for this fragment
        RecyclerView recyclerView = view.findViewById(R.id.recycler_choose);
        final CategoriesAdapter adapter = new CategoriesAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        //Using ViewModelProviders to associate  ViewModel with  UI controller
        ctView = ViewModelProviders.of(this).get(CategoriesViewModel.class);

        ctView.getCategoriesAll().observe(this, new Observer<List<CategoriesDatabase>>() {
            @Override
            public void onChanged(@Nullable List<CategoriesDatabase> categoriesDatabases) {
                adapter.setCategories(categoriesDatabases);

            }
        });



        //adding back arrow
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
