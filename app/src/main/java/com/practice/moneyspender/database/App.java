package com.practice.moneyspender.database;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application{


    public static App instance;

    private AppDataBase appDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        appDataBase = Room.databaseBuilder(this
                , AppDataBase.class
                , "database")
                .build();


    }

    public static App getInstance(){
        return instance;
    }

    public AppDataBase getAppDataBase(){
        return appDataBase;
    }
}
