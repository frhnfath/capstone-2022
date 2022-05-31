package com.frhnfath.submssion2

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @field:SerializedName("items")
    val items: List<GithubResponse>? = null
)