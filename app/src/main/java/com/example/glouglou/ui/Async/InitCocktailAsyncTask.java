package com.example.glouglou.ui.Async;

import android.os.AsyncTask;
import android.util.Log;

import com.example.glouglou.ui.Interfaces.DrinksListener;
import com.example.glouglou.ui.pojo.Drinks;
import com.example.glouglou.ui.retrofit.RetrofitHelper;

public class InitCocktailAsyncTask extends AsyncTask<String,Void, Drinks> {
    public DrinksListener searchListener ;
    public InitCocktailAsyncTask(DrinksListener searchListener){
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
