package com.frhnfath.submssion2

import com.squareup.moshi.Json

data class SearchResponse (
    @field:Json(name = "items")
    val items: List<User>
    )
