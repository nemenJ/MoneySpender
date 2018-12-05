package com.practice.moneyspender.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practice.moneyspender.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseCategoriesFragment extends Fragment {


    public ChooseCategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_categories, container, false);
    }

}
