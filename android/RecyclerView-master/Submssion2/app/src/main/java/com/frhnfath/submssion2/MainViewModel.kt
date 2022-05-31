package com.frhnfath.submssion2

import com.frhnfath.submssion2.Networking.ApiConfig
import com.frhnfath.submssion2.Networking.ApiService

class MainViewModel: _root_ide_package_.androidx.lifecycle.ViewModel() {
    val client = ApiConfig.getApiService().getUsers()
}