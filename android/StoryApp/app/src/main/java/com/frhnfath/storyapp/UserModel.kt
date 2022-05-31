package com.frhnfath.storyapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel (
    val name: String,
    val email: String,
    val password: String,
    val isLogin: Boolean,
    val token: String
    ) : Parcelable