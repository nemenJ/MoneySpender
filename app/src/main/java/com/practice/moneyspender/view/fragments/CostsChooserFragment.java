package com.practice.moneyspender.view.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.practice.moneyspender.R;

import org.w3c.dom.Text;

public class CostsChooserFragment extends Fragment {


    private static final String NAME = "name";
    private String name;
    private TextView costCategory;
    private TextView costDate;
    private static final String DIALOG_DATE = "DialogDate";




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_costs_chooser, container, false);

        // back to home activity , i find it on  https://medium.com/android-grid/how-to-implement-back-up-button-on-toolbar-android-studio-c272bbc0f1b0
        Toolbar toolbar = view.findViewById(R.id.toolbar_choose_fragment);
        toolbar.setTitle(R.string.fragment_chooser);
         costCategory = view.findViewById(R.id.cost_category);
         costDate = view.findViewById(R.id.cost_date);

         costDate.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view) {

                 FragmentManager fragmentManager = getFragmentManager();
                 FragmentDialog fragmentDialog = new FragmentDialog();
                 fragmentDialog.show(fragmentManager, DIALOG_DATE);


             }
         });



         //adding back arrow for toolbar
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                //manager for back to YourCostFragment
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_framelayout, new YourCostFragment())
                        .commit();


                getActivity().setTitle("New transaction");
                costCategory.setText(name);

            }
        });





        name = getArguments() != null ? getArguments().getString(NAME) : "Select category";

        //transfer name
        costCategory.setText(name);
        costCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.beginTransaction()
                        .addToBackStack(null)
                        .add(R.id.content_framelayout, new ChooseCategoriesFragment())
                        .commit();

            }
        });


        // Inflate the layout for this fragment
        return view;


    }


    public static CostsChooserFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString(NAME, name);
        CostsChooserFragment fragment = new CostsChooserFragment();
        fragment.setArguments(args);
        return fragment;

    }

}
