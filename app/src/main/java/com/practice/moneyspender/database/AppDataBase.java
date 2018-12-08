package com.practice.moneyspender.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities =  {CategoriesDatabase.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract CategoriesDao categoriesDao();
    private static volatile AppDataBase INSTANCE;


     static AppDataBase getAppDataBase(final Context context) {

        if(INSTANCE == null) {
            synchronized (AppDataBase.class) {

                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                            , AppDataBase.class
                            , "categories-database")
                            .fallbackToDestructiveMigration()
                            .addCallback(dbCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }


    private static AppDataBase.Callback dbCallback = new AppDataBase.Callback(){

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            new PopulateByAsyncTask(INSTANCE).execute();

        }
    };


    public static class PopulateByAsyncTask extends AsyncTask<Void, Void, Void>{


            private final CategoriesDao ctDao;

            PopulateByAsyncTask(AppDataBase appDb){

                ctDao = appDb.categoriesDao();

            }

        @Override
        protected Void doInBackground(final Void... params) {


                CategoriesDatabase ct = new CategoriesDatabase();
                ct.setFirstLetterCategory("F");
                ct.setCategoryName("Food");
                ctDao.insert(ct);


            return null;
        }
    }




    public static void onDestroyInstance() {
        INSTANCE = null;
    }

    public static AppDataBase getInstance(){
        return INSTANCE;
    }

}
