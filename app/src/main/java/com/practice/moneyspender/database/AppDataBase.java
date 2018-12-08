package com.practice.moneyspender.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities =  {CategoriesDatabase.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract CategoriesDao categoriesDao();
    private static AppDataBase INSTANCE;


     static AppDataBase getAppDataBase(Context context) {

        if(INSTANCE == null){

            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "categories-database")
                    .build();

        }

        return INSTANCE;
    }

    public static void onDestroyInstance() {
        INSTANCE = null;
    }

    public static AppDataBase getInstance(){
        return INSTANCE;
    }

}
