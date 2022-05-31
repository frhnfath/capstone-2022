package com.dicoding.mymoviecatalogue.series

import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.DataDummy

class SeriesViewModel: ViewModel() {
    fun getSeries() = DataDummy.getSeries()
}