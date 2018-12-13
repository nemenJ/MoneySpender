package com.practice.moneyspender.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoriesDatabase { // class for work with room DB and for ChooseCategoriesFragment


    public CategoriesDatabase(String firstLetterCategory, String categoryName) {
        this.firstLetterCategory = firstLetterCategory;
        this.categoryName = categoryName;
    }



    //key
    @PrimaryKey(autoGenerate =  true)
    private long id;


    private String firstLetterCategory;

    private String categoryName;



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



    public static CategoriesDatabase[] categories(){

        return new  CategoriesDatabase[]{

                new CategoriesDatabase("", "Uncategorized"),
                new CategoriesDatabase("F", "Food"),
                new CategoriesDatabase("E", "Entertainment"),
                new CategoriesDatabase("C", "Car"),
                new CategoriesDatabase("H", "Home"),
                new CategoriesDatabase("C", "Clothing"),
                new CategoriesDatabase("E", "Electronics"),
                new CategoriesDatabase("H", "Health and beaty"),
                new CategoriesDatabase("W", "Work"),

        };

    }






}
