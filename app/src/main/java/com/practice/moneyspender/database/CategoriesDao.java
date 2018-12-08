package com.practice.moneyspender.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CategoriesDao {

    @Query("SELECT * FROM categoriesdatabase")
   LiveData<List<CategoriesDatabase>> getAll();

    @Query("SELECT * FROM categoriesdatabase WHERE id = :id")
    CategoriesDatabase getById(long id);


    @Insert
    void insert(CategoriesDatabase categories);

    @Update
    void update(CategoriesDatabase categories);

    @Delete
    void delete(CategoriesDatabase categories);



}
