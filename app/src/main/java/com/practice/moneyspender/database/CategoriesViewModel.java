package com.practice.moneyspender.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class CategoriesViewModel extends AndroidViewModel {

    private CategoriesRepository dbInit;
    //for cache list
    private LiveData<List<CategoriesDatabase>>  categoriesAll;

    //ViewModel for communication repository with user interface
    //also view model safe UI date

    public CategoriesViewModel(@NonNull Application application) {
        super(application);

        dbInit = new CategoriesRepository(application);
        //get categories from list
        categoriesAll = dbInit.getAllCategories();
    }

    public LiveData<List<CategoriesDatabase>> getCategoriesAll() {
        return categoriesAll;
    }

    public void insert(CategoriesDatabase ctDb){
        dbInit.insert(ctDb);
    }
}
