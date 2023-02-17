package com.example.dogglers

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ButtonTests {
    @get:Rule
    val activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `vertical_list_button_is_displayed`() {
        onView(withId(R.id.vertical_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun `horizontal_list_button_is_displayed`() {
        onView(withId(R.id.horizontal_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun `grid_list_button_is_displayed`() {
        onView(withId(com.example.dogglers.R.id.grid_btn)).check(matches(isDisplayed()))
    }
}