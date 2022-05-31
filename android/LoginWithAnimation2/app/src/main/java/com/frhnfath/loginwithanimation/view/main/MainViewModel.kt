package com.frhnfath.loginwithanimation.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.frhnfath.loginwithanimation.model.UserModel
import com.frhnfath.loginwithanimation.model.UserPreference
import kotlinx.coroutines.launch

class MainViewModel(private val pref: UserPreference) : ViewModel() {
    fun getUser(): LiveData<UserModel> {
        return pref.getUser().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }

}