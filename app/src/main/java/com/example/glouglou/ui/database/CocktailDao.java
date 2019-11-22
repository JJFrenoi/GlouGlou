package com.example.glouglou.ui.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.glouglou.ui.pojo.Drink;

import java.util.List;

@Dao
public interface CocktailDao {
    @Query("SELECT * FROM Drink")
    List<Drink> getAll();
    @Query("SELECT * FROM Drink where owner = :userId")
    List<Drink> getAllbyUser(String userId);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void isertAll(List<Drink> drinks);
    @Delete
    void delete(Drink drink);
    @Query("DELETE FROM Drink")
    public void nukeTable();

}
