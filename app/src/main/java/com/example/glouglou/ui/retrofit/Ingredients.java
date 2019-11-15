package com.example.glouglou.ui.retrofit;

public class Ingredients {
    private String ingredient;
    private String mesure ;
    public Ingredients(String ingredient){
        this.ingredient = ingredient;
        this.mesure = "";
    }

    public  Ingredients(String ingredient,String mesure){
        this.ingredient = ingredient;
        this.mesure = mesure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getMesure() {
        return mesure;
    }

    public void setMesure(String mesure) {
        this.mesure = mesure;
    }
}
