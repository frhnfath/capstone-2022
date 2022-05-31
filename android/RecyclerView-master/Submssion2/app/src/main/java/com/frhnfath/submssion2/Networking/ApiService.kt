package com.frhnfath.submssion2.Networking

import com.frhnfath.submssion2.SearchResponse
import com.frhnfath.submssion2.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/users")
    fun getUsers (
        @Query("q")
        query: String
    ): Call<SearchResponse>

    @GET("search/{username}")
    fun getDetailUser (
        @Query("username")
        username: String
    ): Call<User>

    @GET("search/{username}/following")
    fun getFollowing (
        @Query("username")
        username: String
    ): Call<List<User>>

    @GET("search/{username}/followers")
    fun getFollowers (
        @Query("username")
        username: String
    ): Call<List<User>>
}