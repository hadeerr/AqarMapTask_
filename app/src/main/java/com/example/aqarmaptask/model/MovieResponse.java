package com.example.aqarmaptask.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {


    @SerializedName("page")
    int page;
    @SerializedName("results")
    List<Movie> movies;

    public MovieResponse(int page, List<Movie> movies) {
        this.page = page;
        this.movies = movies;
    }
}
