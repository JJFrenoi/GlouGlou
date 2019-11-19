package com.example.glouglou.ui.Async;

import android.os.AsyncTask;

import com.example.glouglou.ui.database.DatabaseHelper;

public class CleanUpBDD extends AsyncTask<Void,Void,Void> {
    @Override
    protected Void doInBackground(Void... voids) {
        DatabaseHelper.getInstance().getCocktailDao().nukeTable();
        return null;
    }
}
