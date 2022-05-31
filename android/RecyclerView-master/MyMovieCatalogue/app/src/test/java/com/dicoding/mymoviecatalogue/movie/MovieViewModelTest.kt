package com.dicoding.mymoviecatalogue.movie

import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertEquals

class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val mv = viewModel.getMovies()
        assertNotNull(mv)
        assertEquals(10, mv.size)
    }
}