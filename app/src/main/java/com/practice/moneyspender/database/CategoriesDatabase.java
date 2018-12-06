package com.practice.moneyspender.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class CategoriesDatabase {


    @PrimaryKey
    public long id;

    public String categoryName;

    public String firstLetterCategory;


}
