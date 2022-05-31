package com.dicoding.mymoviecatalogue

import com.dicoding.mymoviecatalogue.data.DataDummy
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertEquals

class DetailModelTest {
    private val dummyMovie = DataDummy.getMovies()[0]
    private val dummySeries = DataDummy.getSeries()[0]
    private val dummyMovieId = dummyMovie.id
    private val dummySeriesId = dummySeries.id
    private lateinit var viewModel: DetailModel

    @Before
    fun SetMovie() {
        viewModel = DetailModel()
        viewModel.setMovie(dummyMovieId, "movie")
    }

    @Test
    fun GetMovieDetail() {
        viewModel.setMovie(dummyMovie.id, "movie")
        val movie = viewModel.getMovieDetail()
        assertNotNull(movie)
        assertEquals(dummyMovie.id, movie.id)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.overview, movie.overview)
        assertEquals(dummyMovie.duration, movie.duration)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.poster, movie.poster)
    }

    @Before
    fun setSeries() {
        viewModel = DetailModel()
        viewModel.setMovie(dummySeriesId, "series")
    }

    @Test
    fun getSeriesDetail() {
        viewModel.setMovie(dummySeries.id, "series")
        val series = viewModel.getMovieDetail()
        assertNotNull(series)
        assertEquals(dummySeries.id, series.id)
        assertEquals(dummySeries.title, series.title)
        assertEquals(dummySeries.overview, series.overview)
        assertEquals(dummySeries.duration, series.duration)
        assertEquals(dummySeries.genre, series.genre)
        assertEquals(dummySeries.poster, series.poster)
    }
}