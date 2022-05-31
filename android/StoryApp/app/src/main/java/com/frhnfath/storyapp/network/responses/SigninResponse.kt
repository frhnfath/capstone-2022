package com.frhnfath.storyapp.network.responses

import com.google.gson.annotations.SerializedName

data class SigninResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("loginResult")
    val loginResult: SigninResult
)