package com.frhnfath.storyapp.network

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun registerAccount(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<com.frhnfath.storyapp.network.responses.Response>

    @FormUrlEncoded
    @POST("login")
    suspend fun loginAccount(
        @Field("email") email: String,
        @Field("password") password: String
    ) :Call<com.frhnfath.storyapp.network.responses.Response>

    @GET("stories")
    suspend fun addStory(
        @Header("Authorization") token: String
    ) : Call<com.frhnfath.storyapp.network.responses.Response>

    @Multipart
    @POST("stories")
    suspend fun getStories(
        @Header("Authorization") token: String,
        @Part("description") description: String,
        @Part file: MultipartBody.Part
    ) : Call<com.frhnfath.storyapp.network.responses.Response>

}