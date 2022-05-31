package com.dicoding.myunittesting

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4Builder
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import java.util.regex.Pattern.matches

@Runwith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    private val dummyVolume = "504.0"
    private val dummyCircumference = "100.0"
    private val dummySurfaceArea = "396.0"
    private val dummyLength = "12.0"
    private val dummyWidth = "7.0"
    private val dummyHeight = "6.0"
    private val emptyInput = ""
    private val fieldEmpty = "This Field Cannot be Empty"

    @get:Rule
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun assertGetCircumfere() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())

        onView(withId(R.id.btn_calculate_circumfere)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate_circumfere)).perform(click())

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result)).check(matches(withText(dummyCircumference)))
    }
}