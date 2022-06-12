package com.frhnfath.ambuhelp.data.retrofit

import com.frhnfath.ambuhelp.data.response.AmbuHospResponse
import com.frhnfath.ambuhelp.data.response.TokenResponse
import com.frhnfath.ambuhelp.data.response.UserResponse
import retrofit2.Call
import retrofit2.http.*
import java.math.BigInteger

interface ApiService {

    @FormUrlEncoded
    @POST("users/store")
    fun registerUser(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("telepon") telepon: BigInteger
    ) : Call<UserResponse>

    @GET("users/show/{email}")
    fun getUser(
        @Path("email") email: String
    ) : Call<TokenResponse>

    @FormUrlEncoded
    @POST("short/ambulance")
    suspend fun nearestAmbulance (
        @Field("lintang") lintang: Double,
        @Field("bujur") bujur: Double
    ) : AmbuHospResponse

    @FormUrlEncoded
    @POST("short/hospital")
    suspend fun nearestHospital (
        @Field("lintang") lintang: Double,
        @Field("bujur") bujur: Double
    ) : AmbuHospResponse
}