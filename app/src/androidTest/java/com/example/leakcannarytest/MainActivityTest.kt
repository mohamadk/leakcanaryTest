package com.example.leakcannarytest


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import leakcanary.DetectLeaksAfterTestSuccess
import leakcanary.LeakAssertions
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.jvm.internal.Intrinsics

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Rule
    @JvmField
    val leak = DetectLeaksAfterTestSuccess()

    @Test
    fun mainActivityTest() {
        val materialButton = onView(
            allOf(
                withId(R.id.button),
                isDisplayed()
            )
        )
        materialButton.perform(click())
        materialButton.perform(click())

        val secondActivity = onView(
            allOf(
                withId(R.id.second),
                isDisplayed()
            )
        )


        LeakAssertions.assertNoLeaks(tag = "hello")
        secondActivity.perform(click())
        LeakAssertions.assertNoLeaks(tag = "hello 1")
    }
}
