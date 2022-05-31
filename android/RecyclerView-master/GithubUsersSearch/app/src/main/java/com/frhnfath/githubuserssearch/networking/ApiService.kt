package com.frhnfath.githubuserssearch.networking

import com.frhnfath.githubuserssearch.GithubResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("users/{html_url}")
    fun getGithub(
        @Path("html_url") html_url: String
    ): Call<GithubResponse>
}