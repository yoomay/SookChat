package com.example.sookchat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RetroFitApiInterface {
    @GET("getlist.php")
    Call<List<Data>> getData();
}
