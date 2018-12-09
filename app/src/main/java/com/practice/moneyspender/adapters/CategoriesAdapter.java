package com.practice.moneyspender.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.practice.moneyspender.R;
import com.practice.moneyspender.database.CategoriesDatabase;
import com.practice.moneyspender.view.fragments.CostsChooserFragment;

import java.util.List;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private List<CategoriesDatabase> ctDatabase;
    private CategoriesDatabase db;
    private TextView selectCategory;
    private Context context;









    class CategoriesViewHolder extends RecyclerView.ViewHolder{
        private TextView circleCategoryTextView;
        private TextView nameCategoryTextView;

        public CategoriesViewHolder(final View itemView) {

            super(itemView);


            circleCategoryTextView = itemView.findViewById(R.id.circle_category_name);
            nameCategoryTextView = itemView.findViewById(R.id.category_name);
            selectCategory = itemView.findViewById(R.id.cost_category);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    db = ctDatabase.get(getAdapterPosition());
                    String name = db.getCategoryName();

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction()
                            .replace(R.id.content_framelayout, CostsChooserFragment.newInstance(name))
                            .commit();
                }
            });

        }


    }


    private final LayoutInflater inflater;

    public CategoriesAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoriesView = inflater.inflate(R.layout.choose_categories_list, parent, false);
        return new  CategoriesViewHolder(categoriesView);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder categoriesViewHolder, int position) {

        if (ctDatabase != null) {

            db = ctDatabase.get(position);
            categoriesViewHolder.circleCategoryTextView.setText(db.getFirstLetterCategory());
            categoriesViewHolder.nameCategoryTextView.setText(db.getCategoryName());

        } else {

            categoriesViewHolder.nameCategoryTextView.setText(R.string.ct_name);
            categoriesViewHolder.circleCategoryTextView.setText(R.string.ct_word);

        }
    }



       public void setCategories(List<CategoriesDatabase> ct){

            ctDatabase = ct;
            notifyDataSetChanged();

        }






    @Override
    public int getItemCount() {

        if(ctDatabase != null)

            return ctDatabase.size();

        else return 0;
    }




}
