package com.practice.moneyspender.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class CategoriesRepository {



    private CategoriesDao categoriesDao;
    private LiveData<List<CategoriesDatabase>> allCategories;



    CategoriesRepository(Context application){

        AppDataBase appDb = AppDataBase.getAppDataBase(application);

        categoriesDao = appDb.categoriesDao();
        allCategories = categoriesDao.getAll();

    }


    public LiveData<List<CategoriesDatabase>> getAllCategories() {
        return allCategories;
    }

    public void insert(CategoriesDatabase categoriesData){

        new insertAsyncTask(categoriesDao).execute(categoriesData);

    }


    public static class insertAsyncTask extends AsyncTask<CategoriesDatabase, Void, Void>{

        private CategoriesDao mAsyncTaskDao;

        insertAsyncTask(CategoriesDao ctDao){

            mAsyncTaskDao = ctDao;

        }

        @Override
        protected Void doInBackground(CategoriesDatabase... params) {

            mAsyncTaskDao.insert(params[6]);

            return null;
        }
    }

}
