package com.example.glouglou.ui.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Thecocktaildb_Api  {
    @GET("search.php")
    Call<Drinks> getDrinksByFirstLetter(@Query("f") String l );
    @GET("filter.php")
    Call<Drinks>  getDrinksByIngredientName(@Query("i") String i );
}
