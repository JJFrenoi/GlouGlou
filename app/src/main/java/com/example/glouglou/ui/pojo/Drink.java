package com.example.glouglou.ui.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity
public class Drink implements Parcelable {
    @PrimaryKey
    @NonNull
    @SerializedName("idDrink")
    @Expose
    @ColumnInfo
    private String idDrink;
    @SerializedName("strDrink")
    @Expose
    @ColumnInfo
    private String strDrink;
    @SerializedName("strDrinkAlternate")
    @Expose
    @ColumnInfo
    private String strDrinkAlternate;
    @SerializedName("strDrinkES")
    @Expose
    @ColumnInfo
    private String strDrinkES;
    @SerializedName("strDrinkDE")
    @Expose
    @ColumnInfo
    private String strDrinkDE;
    @SerializedName("strDrinkFR")
    @Expose
    @ColumnInfo
    private String strDrinkFR;
    @SerializedName("strDrinkZH-HANS")
    @Expose
    @ColumnInfo
    private String strDrinkZHHANS;
    @SerializedName("strDrinkZH-HANT")
    @Expose
    @ColumnInfo
    private String strDrinkZHHANT;
    @SerializedName("strTags")
    @Expose
    @ColumnInfo
    private String strTags;
    @SerializedName("strVideo")
    @Expose
    @ColumnInfo
    private String strVideo;
    @SerializedName("strCategory")
    @Expose
    @ColumnInfo
    private String strCategory;
    @SerializedName("strIBA")
    @Expose
    @ColumnInfo
    private String strIBA;
    @SerializedName("strAlcoholic")
    @Expose
    @ColumnInfo
    private String strAlcoholic;
    @SerializedName("strGlass")
    @Expose
    @ColumnInfo
    private String strGlass;
    @SerializedName("strInstructions")
    @Expose
    @ColumnInfo
    private String strInstructions;
    @SerializedName("strInstructionsES")
    @Expose
    @ColumnInfo
    private String strInstructionsES;
    @SerializedName("strInstructionsDE")
    @Expose
    @ColumnInfo
    private String strInstructionsDE;
    @SerializedName("strInstructionsFR")
    @Expose
    @ColumnInfo
    private String strInstructionsFR;
    @SerializedName("strInstructionsZH-HANS")
    @Expose
    @ColumnInfo
    private String strInstructionsZHHANS;
    @SerializedName("strInstructionsZH-HANT")
    @Expose
    @ColumnInfo
    private String strInstructionsZHHANT;
    @SerializedName("strDrinkThumb")
    @Expose
    @ColumnInfo
    private String strDrinkThumb;
    @SerializedName("strIngredient1")
    @Expose
    @ColumnInfo
    private String strIngredient1;
    @SerializedName("strIngredient2")
    @Expose
    @ColumnInfo
    private String strIngredient2;
    @SerializedName("strIngredient3")
    @Expose
    @ColumnInfo
    private String strIngredient3;
    @SerializedName("strIngredient4")
    @Expose
    @ColumnInfo
    private String strIngredient4;
    @SerializedName("strIngredient5")
    @Expose
    @ColumnInfo
    private String strIngredient5;
    @SerializedName("strIngredient6")
    @Expose
    @ColumnInfo
    private String strIngredient6;
    @SerializedName("strIngredient7")
    @Expose
    @ColumnInfo
    private String strIngredient7;
    @SerializedName("strIngredient8")
    @Expose
    @ColumnInfo
    private String strIngredient8;
    @SerializedName("strIngredient9")
    @Expose
    @ColumnInfo
    private String strIngredient9;
    @SerializedName("strIngredient10")
    @Expose
    @ColumnInfo
    private String strIngredient10;
    @SerializedName("strIngredient11")
    @Expose
    @ColumnInfo
    private String strIngredient11;
    @SerializedName("strIngredient12")
    @Expose
    @ColumnInfo
    private String strIngredient12;
    @SerializedName("strIngredient13")
    @Expose
    @ColumnInfo
    private String strIngredient13;
    @SerializedName("strIngredient14")
    @Expose
    @ColumnInfo
    private String strIngredient14;
    @SerializedName("strIngredient15")
    @Expose
    @ColumnInfo
    private String strIngredient15;
    @SerializedName("strMeasure1")
    @Expose
    @ColumnInfo
    private String strMeasure1;
    @SerializedName("strMeasure2")
    @Expose
    @ColumnInfo
    private String strMeasure2;
    @SerializedName("strMeasure3")
    @Expose
    @ColumnInfo
    private String strMeasure3;
    @SerializedName("strMeasure4")
    @Expose
    @ColumnInfo
    private String strMeasure4;
    @SerializedName("strMeasure5")
    @Expose
    @ColumnInfo
    private String strMeasure5;
    @SerializedName("strMeasure6")
    @Expose
    @ColumnInfo
    private String strMeasure6;
    @SerializedName("strMeasure7")
    @Expose
    @ColumnInfo
    private String strMeasure7;
    @SerializedName("strMeasure8")
    @Expose
    @ColumnInfo
    private String strMeasure8;
    @SerializedName("strMeasure9")
    @Expose
    @ColumnInfo
    private String strMeasure9;
    @SerializedName("strMeasure10")
    @Expose
    @ColumnInfo
    private String strMeasure10;
    @SerializedName("strMeasure11")
    @Expose
    @ColumnInfo
    private String strMeasure11;
    @SerializedName("strMeasure12")
    @Expose
    @ColumnInfo
    private String strMeasure12;
    @SerializedName("strMeasure13")
    @Expose
    @ColumnInfo
    private String strMeasure13;
    @SerializedName("strMeasure14")
    @Expose
    @ColumnInfo
    private String strMeasure14;
    @SerializedName("strMeasure15")
    @Expose
    @ColumnInfo
    private String strMeasure15;
    @SerializedName("strCreativeCommonsConfirmed")
    @Expose
    @ColumnInfo
    private String strCreativeCommonsConfirmed;
    @SerializedName("dateModified")
    @Expose
    @ColumnInfo
    private String dateModified;
    @SerializedName("owner")
    @Expose
    @ColumnInfo
    private String owner;
    public final static Parcelable.Creator<Drink> CREATOR = new Creator<Drink>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Drink createFromParcel(Parcel in) {
            return new Drink(in);
        }

        public Drink[] newArray(int size) {
            return (new Drink[size]);
        }

    }
            ;

    protected Drink(Parcel in) {
        this.idDrink = ((String) in.readValue((String.class.getClassLoader())));
        this.strDrink = ((String) in.readValue((String.class.getClassLoader())));
        this.strDrinkAlternate = ((String) in.readValue((String.class.getClassLoader())));
        this.strDrinkES = ((String) in.readValue((String.class.getClassLoader())));
        this.strDrinkDE = ((String) in.readValue((String.class.getClassLoader())));
        this.strDrinkFR = ((String) in.readValue((String.class.getClassLoader())));
        this.strDrinkZHHANS = ((String) in.readValue((String.class.getClassLoader())));
        this.strDrinkZHHANT = ((String) in.readValue((String.class.getClassLoader())));
        this.strTags = ((String) in.readValue((String.class.getClassLoader())));
        this.strVideo = ((String) in.readValue((String.class.getClassLoader())));
        this.strCategory = ((String) in.readValue((String.class.getClassLoader())));
        this.strIBA = ((String) in.readValue((String.class.getClassLoader())));
        this.strAlcoholic = ((String) in.readValue((String.class.getClassLoader())));
        this.strGlass = ((String) in.readValue((String.class.getClassLoader())));
        this.strInstructions = ((String) in.readValue((String.class.getClassLoader())));
        this.strInstructionsES = ((String) in.readValue((String.class.getClassLoader())));
        this.strInstructionsDE = ((String) in.readValue((String.class.getClassLoader())));
        this.strInstructionsFR = ((String) in.readValue((String.class.getClassLoader())));
        this.strInstructionsZHHANS = ((String) in.readValue((String.class.getClassLoader())));
        this.strInstructionsZHHANT = ((String) in.readValue((String.class.getClassLoader())));
        this.strDrinkThumb = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient1 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient2 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient3 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient4 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient5 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient6 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient7 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient8 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient9 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient10 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient11 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient12 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient13 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient14 = ((String) in.readValue((String.class.getClassLoader())));
        this.strIngredient15 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure1 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure2 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure3 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure4 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure5 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure6 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure7 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure8 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure9 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure10 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure11 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure12 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure13 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure14 = ((String) in.readValue((String.class.getClassLoader())));
        this.strMeasure15 = ((String) in.readValue((String.class.getClassLoader())));
        this.strCreativeCommonsConfirmed = ((String) in.readValue((String.class.getClassLoader())));
        this.dateModified = ((String) in.readValue((String.class.getClassLoader())));
        this.owner = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Drink() {
    }

    /**
     *
     * @param strDrinkFR
     * @param strInstructionsDE
     * @param strIngredient10
     * @param strDrink
     * @param strIngredient12
     * @param strIngredient11
     * @param strIngredient14
     * @param strCategory
     * @param strAlcoholic
     * @param strIngredient13
     * @param strIngredient15
     * @param strDrinkZHHANS
     * @param strCreativeCommonsConfirmed
     * @param strDrinkZHHANT
     * @param strIBA
     * @param strDrinkES
     * @param strVideo
     * @param strTags
     * @param strInstructions
     * @param strIngredient1
     * @param strIngredient3
     * @param strIngredient2
     * @param strIngredient5
     * @param strIngredient4
     * @param strIngredient7
     * @param strIngredient6
     * @param strInstructionsZHHANS
     * @param strIngredient9
     * @param strInstructionsFR
     * @param strInstructionsZHHANT
     * @param strIngredient8
     * @param idDrink
     * @param strInstructionsES
     * @param strGlass
     * @param strDrinkDE
     * @param strMeasure12
     * @param strMeasure13
     * @param strMeasure10
     * @param strMeasure11
     * @param dateModified
     * @param strDrinkAlternate
     * @param strDrinkThumb
     * @param strMeasure9
     * @param strMeasure7
     * @param strMeasure8
     * @param strMeasure5
     * @param strMeasure6
     * @param strMeasure3
     * @param strMeasure4
     * @param strMeasure1
     * @param strMeasure2
     * @param strMeasure14
     * @param strMeasure15
     */
    @Ignore
    public Drink(String idDrink, String strDrink, String strDrinkAlternate, String strDrinkES, String strDrinkDE, String strDrinkFR, String strDrinkZHHANS, String strDrinkZHHANT, String strTags, String strVideo, String strCategory, String strIBA, String strAlcoholic, String strGlass, String strInstructions, String strInstructionsES, String strInstructionsDE, String strInstructionsFR, String strInstructionsZHHANS, String strInstructionsZHHANT, String strDrinkThumb, String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8, String strIngredient9, String strIngredient10, String strIngredient11, String strIngredient12, String strIngredient13, String strIngredient14, String strIngredient15, String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8, String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12, String strMeasure13, String strMeasure14, String strMeasure15, String strCreativeCommonsConfirmed, String dateModified , String owner) {
        super();
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.strDrinkAlternate = strDrinkAlternate;
        this.strDrinkES = strDrinkES;
        this.strDrinkDE = strDrinkDE;
        this.strDrinkFR = strDrinkFR;
        this.strDrinkZHHANS = strDrinkZHHANS;
        this.strDrinkZHHANT = strDrinkZHHANT;
        this.strTags = strTags;
        this.strVideo = strVideo;
        this.strCategory = strCategory;
        this.strIBA = strIBA;
        this.strAlcoholic = strAlcoholic;
        this.strGlass = strGlass;
        this.strInstructions = strInstructions;
        this.strInstructionsES = strInstructionsES;
        this.strInstructionsDE = strInstructionsDE;
        this.strInstructionsFR = strInstructionsFR;
        this.strInstructionsZHHANS = strInstructionsZHHANS;
        this.strInstructionsZHHANT = strInstructionsZHHANT;
        this.strDrinkThumb = strDrinkThumb;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strIngredient4 = strIngredient4;
        this.strIngredient5 = strIngredient5;
        this.strIngredient6 = strIngredient6;
        this.strIngredient7 = strIngredient7;
        this.strIngredient8 = strIngredient8;
        this.strIngredient9 = strIngredient9;
        this.strIngredient10 = strIngredient10;
        this.strIngredient11 = strIngredient11;
        this.strIngredient12 = strIngredient12;
        this.strIngredient13 = strIngredient13;
        this.strIngredient14 = strIngredient14;
        this.strIngredient15 = strIngredient15;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;
        this.strMeasure4 = strMeasure4;
        this.strMeasure5 = strMeasure5;
        this.strMeasure6 = strMeasure6;
        this.strMeasure7 = strMeasure7;
        this.strMeasure8 = strMeasure8;
        this.strMeasure9 = strMeasure9;
        this.strMeasure10 = strMeasure10;
        this.strMeasure11 = strMeasure11;
        this.strMeasure12 = strMeasure12;
        this.strMeasure13 = strMeasure13;
        this.strMeasure14 = strMeasure14;
        this.strMeasure15 = strMeasure15;
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
        this.dateModified = dateModified;
        this.owner = owner ;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    public void setStrDrinkAlternate(String strDrinkAlternate) {
        this.strDrinkAlternate = strDrinkAlternate;
    }

    public String getStrDrinkES() {
        return strDrinkES;
    }

    public void setStrDrinkES(String strDrinkES) {
        this.strDrinkES = strDrinkES;
    }

    public String getStrDrinkDE() {
        return strDrinkDE;
    }

    public void setStrDrinkDE(String strDrinkDE) {
        this.strDrinkDE = strDrinkDE;
    }

    public String getStrDrinkFR() {
        return strDrinkFR;
    }

    public void setStrDrinkFR(String strDrinkFR) {
        this.strDrinkFR = strDrinkFR;
    }

    public String getStrDrinkZHHANS() {
        return strDrinkZHHANS;
    }

    public void setStrDrinkZHHANS(String strDrinkZHHANS) {
        this.strDrinkZHHANS = strDrinkZHHANS;
    }

    public String getStrDrinkZHHANT() {
        return strDrinkZHHANT;
    }

    public void setStrDrinkZHHANT(String strDrinkZHHANT) {
        this.strDrinkZHHANT = strDrinkZHHANT;
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String getStrVideo() {
        return strVideo;
    }

    public void setStrVideo(String strVideo) {
        this.strVideo = strVideo;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrIBA() {
        return strIBA;
    }

    public void setStrIBA(String strIBA) {
        this.strIBA = strIBA;
    }

    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    public void setStrAlcoholic(String strAlcoholic) {
        this.strAlcoholic = strAlcoholic;
    }

    public String getStrGlass() {
        return strGlass;
    }

    public void setStrGlass(String strGlass) {
        this.strGlass = strGlass;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrInstructionsES() {
        return strInstructionsES;
    }

    public void setStrInstructionsES(String strInstructionsES) {
        this.strInstructionsES = strInstructionsES;
    }

    public String getStrInstructionsDE() {
        return strInstructionsDE;
    }

    public void setStrInstructionsDE(String strInstructionsDE) {
        this.strInstructionsDE = strInstructionsDE;
    }

    public String getStrInstructionsFR() {
        return strInstructionsFR;
    }

    public void setStrInstructionsFR(String strInstructionsFR) {
        this.strInstructionsFR = strInstructionsFR;
    }

    public String getStrInstructionsZHHANS() {
        return strInstructionsZHHANS;
    }

    public void setStrInstructionsZHHANS(String strInstructionsZHHANS) {
        this.strInstructionsZHHANS = strInstructionsZHHANS;
    }

    public String getStrInstructionsZHHANT() {
        return strInstructionsZHHANT;
    }

    public void setStrInstructionsZHHANT(String strInstructionsZHHANT) {
        this.strInstructionsZHHANT = strInstructionsZHHANT;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public void setStrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public void setStrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public void setStrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public void setStrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public void setStrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    public String getStrIngredient11() {
        return strIngredient11;
    }

    public void setStrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    public String getStrIngredient12() {
        return strIngredient12;
    }

    public void setStrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }

    public String getStrIngredient13() {
        return strIngredient13;
    }

    public void setStrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }

    public String getStrIngredient14() {
        return strIngredient14;
    }

    public void setStrIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
    }

    public String getStrIngredient15() {
        return strIngredient15;
    }

    public void setStrIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public void setStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public void setStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public void setStrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public void setStrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public void setStrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public void setStrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public void setStrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    public String getStrMeasure11() {
        return strMeasure11;
    }

    public void setStrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    public String getStrMeasure12() {
        return strMeasure12;
    }

    public void setStrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public void setStrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    public String getStrMeasure14() {
        return strMeasure14;
    }

    public void setStrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    public String getStrMeasure15() {
        return strMeasure15;
    }

    public void setStrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    public String getStrCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    public void setStrCreativeCommonsConfirmed(String strCreativeCommonsConfirmed) {
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getOwner(){return owner;}
    public void setOwner(String owner){this.owner = owner;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idDrink);
        dest.writeValue(strDrink);
        dest.writeValue(strDrinkAlternate);
        dest.writeValue(strDrinkES);
        dest.writeValue(strDrinkDE);
        dest.writeValue(strDrinkFR);
        dest.writeValue(strDrinkZHHANS);
        dest.writeValue(strDrinkZHHANT);
        dest.writeValue(strTags);
        dest.writeValue(strVideo);
        dest.writeValue(strCategory);
        dest.writeValue(strIBA);
        dest.writeValue(strAlcoholic);
        dest.writeValue(strGlass);
        dest.writeValue(strInstructions);
        dest.writeValue(strInstructionsES);
        dest.writeValue(strInstructionsDE);
        dest.writeValue(strInstructionsFR);
        dest.writeValue(strInstructionsZHHANS);
        dest.writeValue(strInstructionsZHHANT);
        dest.writeValue(strDrinkThumb);
        dest.writeValue(strIngredient1);
        dest.writeValue(strIngredient2);
        dest.writeValue(strIngredient3);
        dest.writeValue(strIngredient4);
        dest.writeValue(strIngredient5);
        dest.writeValue(strIngredient6);
        dest.writeValue(strIngredient7);
        dest.writeValue(strIngredient8);
        dest.writeValue(strIngredient9);
        dest.writeValue(strIngredient10);
        dest.writeValue(strIngredient11);
        dest.writeValue(strIngredient12);
        dest.writeValue(strIngredient13);
        dest.writeValue(strIngredient14);
        dest.writeValue(strIngredient15);
        dest.writeValue(strMeasure1);
        dest.writeValue(strMeasure2);
        dest.writeValue(strMeasure3);
        dest.writeValue(strMeasure4);
        dest.writeValue(strMeasure5);
        dest.writeValue(strMeasure6);
        dest.writeValue(strMeasure7);
        dest.writeValue(strMeasure8);
        dest.writeValue(strMeasure9);
        dest.writeValue(strMeasure10);
        dest.writeValue(strMeasure11);
        dest.writeValue(strMeasure12);
        dest.writeValue(strMeasure13);
        dest.writeValue(strMeasure14);
        dest.writeValue(strMeasure15);
        dest.writeValue(strCreativeCommonsConfirmed);
        dest.writeValue(dateModified);
        dest.writeValue(owner);

    }
}