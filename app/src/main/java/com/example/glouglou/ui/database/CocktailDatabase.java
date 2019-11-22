package com.example.glouglou.ui.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.glouglou.ui.pojo.Drink;

@Database(entities = {Drink.class}, version = 2)
public abstract class CocktailDatabase extends RoomDatabase {
    public abstract CocktailDao cocktailDao();
}
