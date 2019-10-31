package com.example.glouglou.ui.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Thecocktaildb_Api  {
    @GET("filter.php?c=Cocktail")
    Call<Drinks> getDrinks();
}
