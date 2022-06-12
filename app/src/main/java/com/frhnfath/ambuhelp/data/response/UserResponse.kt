package com.frhnfath.ambuhelp.data.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<UserDataItem>,

	@field:SerializedName("message")
	val message: String
)

data class UserDataItem(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("telepon")
	val telepon: String,

	@field:SerializedName("email")
	val email: String
)
