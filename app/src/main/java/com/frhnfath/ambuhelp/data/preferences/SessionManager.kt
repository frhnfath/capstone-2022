package com.frhnfath.ambuhelp.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.frhnfath.ambuhelp.data.response.TokenDataItem

internal class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val TOKEN = "token"
        private const val PREFS_NAME = "user_pref"
        private const val LOGIN = "is_login"
    }

    fun saveToken(token: List<TokenDataItem>) {
        val editor = prefs.edit()
        Log.d("Early Session", "session: ${prefs.edit()}")
        editor.putString(TOKEN, token.toString())
        editor.apply()
        Log.d("Token ", "saveToken: $token")
    }

    fun fetchToken() {
        prefs.edit().remove("token").commit()
        Log.d("Session", "fetchSession: ${prefs.edit()}")
    }

    fun getSession(): Boolean {
        var isLogin = false
        if (prefs.getString(TOKEN, null) != null) isLogin = true
        Log.d("Session", "getSession: ${prefs.getString(TOKEN, null)}")
        return isLogin
    }
}