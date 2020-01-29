package com.example.aqarmaptask.network;

import com.example.aqarmaptask.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

@GET("/discover/movie?api_key=f5cacc2efe1d74dd3b1ee9ba5ac78a3d?sort_by=popularity.desc")
Call<MovieResponse> getMovies();
}
