package com.frhnfath.ambuhelp.viewmodel

import androidx.lifecycle.ViewModel
import com.frhnfath.ambuhelp.data.repository.MapsRepository

class MainViewModel(
    private val mapsRepository: MapsRepository
): ViewModel() {
    fun getNearestAmbulance(lintang: Double, bujur: Double) = mapsRepository.nearestAmbulance(lintang, bujur)

    fun getNearestHospital(lintang: Double, bujur: Double) = mapsRepository.nearestHospital(lintang, bujur)
}