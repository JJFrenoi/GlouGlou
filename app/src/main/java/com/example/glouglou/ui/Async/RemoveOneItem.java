package com.example.glouglou.ui.Async;

import android.os.AsyncTask;

import com.example.glouglou.ui.database.DatabaseHelper;
import com.example.glouglou.ui.pojo.Drink;

public class RemoveOneItem extends AsyncTask<Drink,Void,Void> {
    @Override
    protected Void doInBackground(Drink... drinks) {
        if (drinks!=null && drinks.length>0) {
            DatabaseHelper.getInstance().getCocktailDao().delete(drinks[0]);
        }
        return null;
    }
}
