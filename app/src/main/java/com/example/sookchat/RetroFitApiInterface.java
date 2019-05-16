package com.example.sookchat;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RetroFitApiInterface {
    @GET("getlist.php")
    Call<List<Data>> getData();


}
