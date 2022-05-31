package com.dicoding.myunittesting

import com.dicoding.myunittesting.CuboidModel

class MainViewModel(private val cuboidModel: CuboidModel) {
    fun getCircumference(): Double = cuboidModel.getCircumfere()

    fun getSurfaceArea(): Double = cuboidModel.getSurfaceArea()

    fun getVolume(): Double = cuboidModel.getVolume()

    fun save(l: Double, w: Double, h: Double) {
        cuboidModel.save(l, w, h)
    }
}