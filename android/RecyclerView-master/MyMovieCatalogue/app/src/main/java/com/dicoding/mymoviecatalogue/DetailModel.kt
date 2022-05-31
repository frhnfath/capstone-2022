package com.dicoding.mymoviecatalogue

import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.DataDummy
import com.dicoding.mymoviecatalogue.data.MovieEntity

class DetailModel: ViewModel() {
    companion object {
        const val SERIES = "series"
        const val MOVIE = "movie"
    }

    private lateinit var mv: MovieEntity

    fun setMovie(id: String, category: String) {
        when (category) {
            MOVIE -> {
                for (movie in DataDummy.getMovies()) {
                    if (movie.id == id) mv = movie
                }
            }

            SERIES -> {
                for (series in DataDummy.getSeries()) {
                    if (series.id == id) mv = series
                }
            }
        }
    }

    fun getMovieDetail() = mv
}