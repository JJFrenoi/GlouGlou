package com.example.glouglou.ui.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class Drinks implements Parcelable {
    @SerializedName("drinks")
    @Expose
    private List<Drink> drinks = null;
    public final static Parcelable.Creator<Drinks> CREATOR = new Creator<Drinks>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Drinks createFromParcel(Parcel in) {
            return new Drinks(in);
        }

        public Drinks[] newArray(int size) {
            return (new Drinks[size]);
        }

    };
    protected Drinks(Parcel in) {
        in.readList(this.drinks, (Drink.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Drinks() {
    }

    /**
     *
     * @param drinks
     */
    public Drinks(List<Drink> drinks) {
        super();
        this.drinks = drinks;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }
    public void addAll(List<Drink> drinks){
        this.drinks.addAll(drinks);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(drinks);

    }
}
