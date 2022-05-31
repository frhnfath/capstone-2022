package com.dicoding.mymoviecatalogue.data

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class MovieEntity(
    val id: String,
    val title: String,
    val overview: String,
    val duration: String,
    val genre: String,
    val poster: Int
) : Parcelable