package com.frhnfath.storyapp.network.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListStoryResponse (

    @field:SerializedName("photoUrl")
    val photoUrl: String,

    @field:SerializedName("createdAt")
    val createdAt: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("id")
    val id: String
) : Parcelable