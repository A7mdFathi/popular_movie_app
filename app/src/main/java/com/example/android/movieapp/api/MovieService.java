package com.example.android.movieapp.api;

import com.example.android.movieapp.model.MovieResponse;
import com.example.android.movieapp.model.Review;
import com.example.android.movieapp.model.ReviewResponse;
import com.example.android.movieapp.model.TrailerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ahmed on 04/09/18.
 */

public interface MovieService {

    @GET("movie/{sort_by}")
    Call<MovieResponse> getMovies(@Path("sort_by") String sortBy, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/videos")
    Call<TrailerResponse> getMovieTrailer(@Path("movie_id") int id, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/reviews")
    Call<ReviewResponse> getMovieReview(@Path("movie_id") int id, @Query("api_key") String apiKey);

}
