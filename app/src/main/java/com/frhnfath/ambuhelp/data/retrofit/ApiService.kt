package com.frhnfath.ambuhelp.data.retrofit

import com.frhnfath.ambuhelp.data.response.AmbuHospResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
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