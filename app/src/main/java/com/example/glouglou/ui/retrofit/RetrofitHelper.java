package com.example.glouglou.ui.retrofit;
import com.example.glouglou.ui.pojo.Drinks;
import com.example.glouglou.ui.pojo.Thecocktaildb_Api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitHelper {
    private static final List<String> listIngredient = new ArrayList<>(Arrays.asList(
            "Light rum",
            "Applejack",
            "Gin",
            "Dark rum",
            "Sweet Vermouth",
            "Strawberry schnapps",
            "Scotch",
            "Apricot brandy",
            "Triple sec",
            "Southern Comfort",
            "Orange bitters",
            "Brandy",
            "Lemon vodka",
            "Blended whiskey",
            "Dry Vermouth",
            "Amaretto",
            "Tea",
            "Champagne",
            "Coffee liqueur",
            "Bourbon",
            "Tequila",
            "Vodka",
            "Añejo rum",
            "Bitters",
            "Sugar",
            "Kahlua",
            "demerara Sugar",
            "Dubonnet Rouge",
            "Lime juice",
            "Irish whiskey",
            "Apple brandy",
            "Carbonated water",
            "Cherry brandy",
            "Creme de Cacao",
            "Grenadine",
            "Port",
            "Coffee brandy",
            "Red wine",
            "Rum",
            "Grapefruit juice",
            "Ricard",
            "Sherry",
            "Cognac",
            "Sloe gin",
            "Apple juice",
            "Pineapple juice",
            "Lemon juice",
            "Sugar syrup",
            "Milk",
            "Strawberries",
            "Chocolate syrup",
            "Yoghurt",
            "Mango",
            "Ginger",
            "Lime",
            "Cantaloupe",
            "Berries",
            "Grapes",
            "Kiwi",
            "Tomato juice",
            "Cocoa powder",
            "Chocolate",
            "Heavy cream",
            "Galliano",
            "Peach Vodka",
            "Ouzo",
            "Coffee",
            "Spiced rum",
            "Water",
            "Espresso",
            "Angelica root",
            "Orange",
            "Cranberries",
            "Johnnie Walker",
            "Apple cider",
            "Everclear",
            "Cranberry juice",
            "Egg yolk",
            "Egg",
            "Grape juice",
            "Peach nectar",
            "Lemon",
            "Firewater",
            "Lemonade",
            "Lager",
            "Whiskey",
            "Absolut Citron",
            "Pisco",
            "Irish cream",
            "Ale",
            "Chocolate liqueur",
            "Midori melon liqueur",
            "Sambuca",
            "Cider",
            "Sprite",
            "7-Up",
            "Blackberry brandy",
            "Peppermint schnapps",
            "Creme de Cassis",
            "Jack Daniels"
    ));
    private static Retrofit retrofit = null ;
    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";
    private Thecocktaildb_Api thecocktaildb_api ;
    private Call<Drinks> call ;
    public RetrofitHelper(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        thecocktaildb_api = retrofit.create(Thecocktaildb_Api.class);
        call = thecocktaildb_api.random();
    }
    public RetrofitHelper(String s ){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        thecocktaildb_api = retrofit.create(Thecocktaildb_Api.class);
        if (s.length() == 1){
            call = thecocktaildb_api.getDrinksByFirstLetter(s);
        }
        else if (listIngredient.contains(s)){
            call = thecocktaildb_api.getDrinksByIngredientName(s);
        }
        else {
            call = thecocktaildb_api.getCocktailByName(s);
        }

    }

    public static List<String> getListIngredient() {
        return listIngredient;
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public Thecocktaildb_Api getThecocktaildb_api() {
        return thecocktaildb_api;
    }

    public Call<Drinks> getCall() {
        return call;
    }
}
