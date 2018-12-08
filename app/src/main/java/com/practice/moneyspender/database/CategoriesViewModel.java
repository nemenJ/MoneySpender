package com.practice.moneyspender.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class CategoriesViewModel extends AndroidViewModel {

    private DatabaseInit dbInit;
    private LiveData<List<CategoriesDatabase>>  categoriesAll;



    public CategoriesViewModel(@NonNull Application application) {
        super(application);

        dbInit = new DatabaseInit(application);
        categoriesAll = dbInit.getAllCategories();
    }

    public LiveData<List<CategoriesDatabase>> getCategoriesAll() {
        return categoriesAll;
    }

    public void insert(CategoriesDatabase ctDb){
        dbInit.insert(ctDb);
    }
}
