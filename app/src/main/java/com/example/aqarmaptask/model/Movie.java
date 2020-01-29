package com.example.aqarmaptask.model;

import android.util.Log;

import com.example.aqarmaptask.network.ApiClient;
import com.example.aqarmaptask.network.ApiInterface;
import com.example.aqarmaptask.view.viewInterface;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Movie {
    @SerializedName("popularity")
    double popularity;
    @SerializedName("vote_count")
    int vote_count;
    @SerializedName("video")
    boolean video;
    @SerializedName("poster_path")
    String poster_path;
    @SerializedName("id")
    int id;
    @SerializedName("adult")
    boolean adult;
    @SerializedName("backdrop_path")
    String backdrop_path;
    @SerializedName("original_language")
    String original_language;
    @SerializedName("original_title")
    String original_title;
    @SerializedName("title")
    String title;
    @SerializedName("vote_average")
    int vote_average;
    @SerializedName("overview")
    String overview;
    @SerializedName("release_date")
    String release_date;

    public Movie(double popularity, int vote_count, boolean video, String poster_path, int id, boolean adult, String backdrop_path, String original_language, String original_title, String title, int vote_average, String overview, String release_date) {
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.poster_path = poster_path;
        this.id = id;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.title = title;
        this.vote_average = vote_average;
        this.overview = overview;
        this.release_date = release_date;
    }

    public Movie() {
    }

    public  void getLisFromApi(viewInterface viewInterface){
        ApiClient.getClient().create(ApiInterface.class).getMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = new ArrayList<>();
                MovieResponse response1 = response.body();
                movies.addAll(response1.movies);
                viewInterface.setList(movies);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e("EEEEEEEEERR" , t.toString());

            }
        });

    }
}
