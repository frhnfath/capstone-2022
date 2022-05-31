package com.frhnfath.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var username: String?,
    var name: String?,
    var company: String?,
    var photo: Int,
    var following: String?,
    var followers: String?,
    var location: String?,
    var repository: String?
) : Parcelable