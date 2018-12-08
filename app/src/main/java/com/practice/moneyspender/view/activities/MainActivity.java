package com.practice.moneyspender.view.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


import com.practice.moneyspender.R;
import com.practice.moneyspender.view.fragments.StatisticFragment;
import com.practice.moneyspender.view.fragments.YourCostFragment;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
        implements  NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DatabaseInit



        //Toolbar add
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Adding HamburgerButton
         drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggleButton = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.nav_open,
                R.string.nav_close
        );

        drawerLayout.addDrawerListener(toggleButton);
        toggleButton.syncState();

        //Adding NavigationView and Listener for it
        NavigationView navigationView = findViewById(R.id.nav_view_main);
        navigationView.setNavigationItemSelectedListener(this);


        //CostFragment and transaction for it
        Fragment fragmentCost = new YourCostFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content_framelayout, fragmentCost);
        fragmentTransaction.commit();

        //Images Picasso

        View header = navigationView.getHeaderView(0);

        ImageView imageViewNavHeader = header.findViewById(R.id.header_img);
        Picasso.get()
                .load("https://cdn.dribbble.com/users/74133/screenshots/1888531/avatar-cool.jpg")
                .fit()
                .into(imageViewNavHeader);


    }

    //Method for choosing commands on Navigation Pannel
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        Fragment fragment;
        switch (menuItem.getItemId()){

            case R.id.menu_cost:
                fragment = new YourCostFragment();
                onStartFragment(fragment);
                break;

            case R.id.menu_statistic:
                fragment = new StatisticFragment();
                onStartFragment(fragment);
                break;
        }


            drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    //Method for Fragment replace
    public void onStartFragment(Fragment createFragment){

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_framelayout, createFragment)
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onBackPressed() {


        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }
}
