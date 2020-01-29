package com.example.aqarmaptask.network;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    final  static  String url = "https://api.themoviedb.org/3";

    public  static Retrofit getClient() {



        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        return retrofit;
    }
}
