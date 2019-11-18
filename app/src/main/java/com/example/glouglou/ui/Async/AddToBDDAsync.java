package com.example.glouglou.ui.Async;

import android.os.AsyncTask;

import com.example.glouglou.ui.database.DatabaseHelper;
import com.example.glouglou.ui.pojo.Drinks;

public class AddToBDDAsync extends AsyncTask<Drinks, Void, Void> {
    @Override
    protected Void doInBackground(Drinks... drinks) {
        if (drinks!=null && drinks.length>0){
            DatabaseHelper.getInstance().getCocktailDao().isertAll(drinks[0].getDrinks());
        }
        return null;
    }
}
