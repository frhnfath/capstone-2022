package com.frhnfath.ambuhelp.data.response

import com.google.gson.annotations.SerializedName

data class TokenResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<TokenDataItem>,

	@field:SerializedName("message")
	val message: String
)

data class TokenDataItem(

	@field:SerializedName("remember_token")
	val rememberToken: String
)
