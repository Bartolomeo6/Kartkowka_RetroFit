package com.example.kartkowka_retrofit;

import androidx.core.app.GrammaticalInflectionManagerCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {
    @GET("gryPlanszowe")
    Call<List<Planszowka>> getPlanszowki();
}
