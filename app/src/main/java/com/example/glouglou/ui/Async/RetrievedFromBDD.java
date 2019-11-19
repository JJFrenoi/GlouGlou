package com.example.glouglou.ui.Async;

import android.os.AsyncTask;

import com.example.glouglou.ui.Interfaces.DrinksListener;
import com.example.glouglou.ui.database.DatabaseHelper;
import com.example.glouglou.ui.pojo.Drink;
import com.example.glouglou.ui.pojo.Drinks;

import java.util.List;

public class RetrievedFromBDD extends AsyncTask<Void,Void, Drinks> {
    private DrinksListener drinksListener ;
    public RetrievedFromBDD(DrinksListener drinksListener){
        this.drinksListener = drinksListener;
    }
    @Override
    protected Drinks doInBackground(Void... voids) {
        List<Drink> drinks = DatabaseHelper.getInstance().getCocktailDao().getAll();
        if (drinks !=null){
            Drinks drinks1  = new Drinks(drinks);
            return drinks1;
        }else {
            return null;
        }

    }

    @Override
    protected void onPostExecute(Drinks drinks) {
        super.onPostExecute(drinks);
        drinksListener.onDrinksRetrieved(drinks);

    }
}
