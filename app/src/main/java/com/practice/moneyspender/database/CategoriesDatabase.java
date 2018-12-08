package com.practice.moneyspender.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class CategoriesDatabase {


    @PrimaryKey(autoGenerate =  true)
    private long id;

    private String categoryName;

    private String firstLetterCategory;

    public void setId(long id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



    public void setFirstLetterCategory(String firstLetterCategory) {
        this.firstLetterCategory = firstLetterCategory;
    }

    public long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getFirstLetterCategory() {
        return firstLetterCategory;
    }
}
