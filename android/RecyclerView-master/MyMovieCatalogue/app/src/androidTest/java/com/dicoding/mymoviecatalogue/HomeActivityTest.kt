package com.dicoding.mymoviecatalogue

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import com.dicoding.mymoviecatalogue.data.DataDummy
import org.junit.Before
import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.equalTo

class HomeActivityTest {
    private val dummySeries = DataDummy.getSeries()
    private val dummyMovies = DataDummy.getMovies()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMv() {
        onView(withId(R.id.rv_film)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_film)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMv() {
        onView(withId(R.id.rv_film)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail)).check(matches(withTagValue(equalTo(dummyMovies[0].poster))))
        onView(withId(R.id.collaps)).check(matches(isDisplayed()))
        onView(withId(R.id.collaps)).check(matches(withContentDescription(dummyMovies[0].title)))
        onView(withId(R.id.detail_tv_genre_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_genre_duration)).check(matches(withText("${dummyMovies[0].genre} | ${dummyMovies[0].duration}")))
        onView(withId(R.id.detail_tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_overview)).check(matches(withText(dummyMovies[0].overview)))
    }

    @Test
    fun loadSeries() {
        onView(withText("Series")).perform(click())
        onView(withId(R.id.rv_series)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_series)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummySeries.size))
    }

    @Test
    fun loadDetailSeries() {
        onView(withText("Series")).perform(click())
        onView(withId(R.id.rv_series)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.collaps)).check(matches(isDisplayed()))
        onView(withId(R.id.collaps)).check(matches(withContentDescription(dummySeries[0].title)))
        onView(withId(R.id.detail_tv_genre_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_genre_duration)).check(matches(withText("${dummySeries[0].genre} | ${dummySeries[0].duration}")))
        onView(withId(R.id.detail_tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_overview)).check(matches(withText(dummySeries[0].overview)))
        onView(withId(R.id.img_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail)).check(matches(withTagValue(equalTo(dummySeries[0].poster))))
    }
}