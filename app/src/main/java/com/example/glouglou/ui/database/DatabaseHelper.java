package com.example.glouglou.ui.database;

import androidx.room.Room;

import com.example.glouglou.MainActivity;

public class DatabaseHelper {
    static DatabaseHelper instance = null;
    private final CocktailDatabase db;
    public static DatabaseHelper getInstance(){
        if(instance == null){
            instance = new DatabaseHelper();
        }
        return instance;
    }
    public CocktailDao getCocktailDao(){
        return db.cocktailDao();
    }
    public DatabaseHelper(){
        db = Room.databaseBuilder(MainActivity.getContext(),
                CocktailDatabase.class,"CocktailBDD.db").fallbackToDestructiveMigration().build();
    }

}
