package com.example.glouglou.ui.Async;

import android.os.AsyncTask;

import com.example.glouglou.ui.pojo.Drink;

import java.util.List;

public class initCocktailAsyncTask extends AsyncTask<String,Void, List<Drink>> {
    @Override
    protected List<Drink> doInBackground(String... s) {
        if((null!=s)&& (s.length>0)){

        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Drink> drinks) {
        super.onPostExecute(drinks);
    }
}
