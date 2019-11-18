package com.example.glouglou.ui.Async;

import android.os.AsyncTask;
import android.util.Log;

import com.example.glouglou.ui.database.DatabaseHelper;
import com.example.glouglou.ui.pojo.Drink;
import com.example.glouglou.ui.pojo.Drinks;
import com.example.glouglou.ui.retrofit.RetrofitHelper;
import com.example.glouglou.ui.searchBoad.SearchListener;

import java.util.List;

public class InitCocktailAsyncTask extends AsyncTask<String,Void, Drinks> {
    public SearchListener searchListener ;
    public InitCocktailAsyncTask(SearchListener searchListener){
        this.searchListener = searchListener;
    }
    @Override
    protected Drinks doInBackground(String... s) {
        if((null!=s)&& (s.length>0)){
            RetrofitHelper retrofitHelper = new RetrofitHelper("A");
            try {
                Drinks drinks = retrofitHelper.getCall().execute().body();
                return drinks ;
            }catch (Exception e ){
                Log.d("JEAN","Marchepowa");
            }

        }
        return null;
    }

    @Override
    protected void onPostExecute(Drinks drinks) {
        super.onPostExecute(drinks);
        searchListener.onDrinksRetrieved(drinks);
    }
}
