package com.practice.moneyspender.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities =  {CategoriesDatabase.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract CategoriesDao categoriesDao();

}
