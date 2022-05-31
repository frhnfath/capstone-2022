package com.frhnfath.storyapp

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import java.util.prefs.Preferences

class UserPreferences private constructor(private val dataStore: DataStore<Preferences>){
    companion object {

        // create variables to store login data
        @Volatile
        private var INSTANCE: UserPreferences? = null
        private val NAME_KEY = stringPreferencesKey("name")
        private val EMAIL_KEY = stringPreferencesKey("email")
        private val PASSWORD_KEY = stringPreferencesKey("password")
        private val STATE_KEY = booleanPreferencesKey("state")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}