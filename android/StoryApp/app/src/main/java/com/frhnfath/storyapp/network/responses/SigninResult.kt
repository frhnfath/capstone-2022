package com.frhnfath.storyapp.network.responses

import com.google.gson.annotations.SerializedName

data class SigninResult (

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("userId")
    val userId: String,

    @field:SerializedName("token")
    val token: String
)