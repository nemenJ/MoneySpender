package com.practice.moneyspender.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.practice.moneyspender.R;

public class YourCostFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_your_cost, container, false);

        //Adding *plus* button  and click listener for it
        ImageButton costChange = view.findViewById(R.id.button_cost);
        costChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //manager for transition to CostChooserFragment
                FragmentManager ft =  getActivity().getSupportFragmentManager();
                ft.beginTransaction()
                        .replace(R.id.content_framelayout, new CostsChooserFragment())
                        .addToBackStack(null)
                        .commit();

            }
        });

        return view;
    }


}
