package com.frhnfath.storyapp.network.responses

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class Response(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)