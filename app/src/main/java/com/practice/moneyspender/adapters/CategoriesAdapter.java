package com.practice.moneyspender.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.practice.moneyspender.R;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private TextView circleCategoryTextView;
    private TextView nameCategoryTextView;


    class CategoriesViewHolder extends RecyclerView.ViewHolder{


        public CategoriesViewHolder(LayoutInflater inflater, ViewGroup parent) {

            super(inflater.inflate(R.layout.choose_categories_list, parent));


            circleCategoryTextView = itemView.findViewById(R.id.circle_category_name);
            nameCategoryTextView = itemView.findViewById(R.id.category_name);

        }
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new  CategoriesViewHolder(inflater, parent);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder categoriesViewHolder, int i) {





    }

    @Override
    public int getItemCount() {
        return 10;
    }



}
