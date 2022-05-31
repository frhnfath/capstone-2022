package com.frhnfath.storyapp.network.responses

import com.google.gson.annotations.SerializedName

data class StoriesResponse (
    @field:SerializedName("listStory")
    val listStory: List<ListStoryResponse>,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
    )