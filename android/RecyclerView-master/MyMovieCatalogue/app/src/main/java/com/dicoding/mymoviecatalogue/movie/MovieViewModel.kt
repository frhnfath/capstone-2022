package com.dicoding.mymoviecatalogue.movie

import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.DataDummy

class MovieViewModel: ViewModel() {
    fun getMovies() = DataDummy.getMovies()
}