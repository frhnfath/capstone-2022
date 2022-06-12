package com.frhnfath.ambuhelp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.frhnfath.ambuhelp.data.StateResult
import com.frhnfath.ambuhelp.data.response.DataItem
import com.frhnfath.ambuhelp.data.retrofit.ApiService
import java.lang.Exception

class MapsRepository(
    private val apiService: ApiService
) {
    fun nearestAmbulance(lintang: Double, bujur: Double): LiveData<StateResult<List<DataItem>>> = liveData {
        emit(StateResult.Loading)
        try {
            val client = apiService.nearestAmbulance(lintang, bujur)
            if (client.message == "Success") {
                emit(StateResult.Success(client.data))
            } else {
                emit(StateResult.Zero)
            }
        } catch (e: Exception) {
            emit(StateResult.Error(e.message.toString()))
        }
    }

    fun nearestHospital(lintang: Double, bujur: Double): LiveData<StateResult<List<DataItem>>> = liveData {
        emit(StateResult.Loading)
        try {
            val client = apiService.nearestHospital(lintang, bujur)
            if (client.message == "Success") {
                emit(StateResult.Success(client.data))
            } else {
                emit(StateResult.Zero)
            }
        } catch (e: Exception) {
            emit(StateResult.Error(e.message.toString()))
        }
    }

    companion object {
        @Volatile
        private var instance: MapsRepository? = null
        fun getInstance(
            apiService: ApiService
        ): MapsRepository =
            instance ?: synchronized(this) {
                instance ?: MapsRepository(apiService)
            }.also { instance = it }
    }
}