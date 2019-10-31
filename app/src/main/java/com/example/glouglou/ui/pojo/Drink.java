package com.example.glouglou.ui.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Drink {

    @SerializedName("strDrink")
    @Expose
    private String strDrink;
    @SerializedName("strDrinkThumb")
    @Expose
    private String strDrinkThumb;
    @SerializedName("idDrink")
    @Expose
    private String idDrink;

    /**
     * No args constructor for use in serialization
     *
     */
    public Drink() {
    }

    /**
     *
     * @param strDrink
     * @param strDrinkThumb
     * @param idDrink
     */
    public Drink(String strDrink, String strDrinkThumb, String idDrink) {
        super();
        this.strDrink = strDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.idDrink = idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

}