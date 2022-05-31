package com.dicoding.mymoviecatalogue.series

import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull

class SeriesViewModelTest {
    private lateinit var viewModel: SeriesViewModel

    @Before
    fun setUp() {
        viewModel = SeriesViewModel()
    }

    @Test
    fun getSeries() {
        val series = viewModel.getSeries()
        assertNotNull(series)
        assertEquals(10, series.size)
    }
}