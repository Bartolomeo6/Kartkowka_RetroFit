package com.example.kartkowka_retrofit;

import com.google.gson.annotations.SerializedName;

public class Planszowka {

    @SerializedName("nazwa")
    private String nazwa;

    @SerializedName("minWiek")
    private int minWiek;

    @SerializedName("minLG")
    private int minLG;

    @SerializedName("maxLG")
    private int maxLG;

    @SerializedName("czasGrania")
    private int czasGrania;

    public String getNazwa() {
        return nazwa;
    }

    public int getMinWiek() {
        return minWiek;
    }

    public int getMinLG() {
        return minLG;
    }

    @Override
    public String toString() {
        return nazwa + " \n Minimalny wiek: " + minWiek + "\n Minimalna Liczba Graczy: "+ minLG + " \n Maksymalna liczba Graczy: "+ maxLG + " \n Potencjalny czas grania: "+ czasGrania + " min";
    }

    public int getMaxLG() {
        return maxLG;
    }

    public int getCzasGrania() {
        return czasGrania;
    }


}
