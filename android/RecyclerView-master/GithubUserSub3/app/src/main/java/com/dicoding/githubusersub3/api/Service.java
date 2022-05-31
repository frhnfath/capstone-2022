package com.dicoding.githubusersub3.api;

import androidx.room.Query;

import com.dicoding.githubusersub3.data.SearchResponse;
import com.dicoding.githubusersub3.data.User;
import com.dicoding.githubusersub3.data.UserDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface Service {

    @GET("/users")
    Call<List<User>> getGithubUser(@Header("Authorization") String token);


    @GET("/users/{username}/followers")
    Call<List<User>> getUserFollowers(@Path("username") String username);

    @GET("/users/{username}/following")
    Call<List<User>> getUserFollowing(@Path("username") String username);


    @GET("/search/users")
    Call<SearchResponse> getGithubSearch(
            @Query("q") String username
    );

    @GET("users/{username}")
    Call<UserDetail> getUserDetail(@Path("username") String username);
}
