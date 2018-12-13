package com.practice.moneyspender.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

//dao for giving queries for DB
@Dao
public interface CategoriesDao {

    //Methods for working with DB

    //method for getting all categories
    @Query("SELECT * FROM categoriesdatabase")
    //use LiveData for data observing and for  running the query asynchronously on a background thread
   LiveData<List<CategoriesDatabase>> getAll();

    //method for getting category by id
    @Query("SELECT * FROM categoriesdatabase WHERE id = :id")
    CategoriesDatabase getById(long id);


    @Insert
    void insert(CategoriesDatabase ... categories);

    @Update
    void update(CategoriesDatabase categories);

    @Delete
    void delete(CategoriesDatabase categories);



}
