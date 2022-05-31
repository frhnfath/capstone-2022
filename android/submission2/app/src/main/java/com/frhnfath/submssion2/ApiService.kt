package com.frhnfath.submssion2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    fun getSearch (
        @Query("q")
        query: String
    ): Call<ArrayList<SearchResponse>>

    @GET("users/{username}")
    fun getUserDetail (
        @Query("username")
        username: String
    ): Call<GithubResponse>

    @GET("users/{username}/following")
    fun getUserFollowing (
        @Query("following")
        following: String
    ): Call<List<GithubResponse>>

    @GET("users/{username}/followers")
    fun getUserFollowers (
        @Query("followers")
        followers: String
    ): Call<List<GithubResponse>>

}