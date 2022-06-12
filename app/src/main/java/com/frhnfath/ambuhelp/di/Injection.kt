package com.frhnfath.ambuhelp.di

import com.frhnfath.ambuhelp.data.repository.MapsRepository
import com.frhnfath.ambuhelp.data.retrofit.ApiConfig

object Injection {
    fun provideRepository(): MapsRepository {
        val apiService = ApiConfig.getApiService()
        return MapsRepository.getInstance(apiService)
    }
}