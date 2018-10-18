package com.halove.xyp.androidanitest


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val appCompatButton = onView(
                allOf(withId(R.id.alpha_btn), withText("alpha"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()))
        appCompatButton.perform(click())

        val appCompatButton2 = onView(
                allOf(withId(R.id.rotate_btn), withText("rotate"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()))
        appCompatButton2.perform(click())

        val appCompatButton3 = onView(
                allOf(withId(R.id.scale_btn), withText("scale"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()))
        appCompatButton3.perform(click())

        val appCompatButton4 = onView(
                allOf(withId(R.id.translate_btn), withText("translate"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()))
        appCompatButton4.perform(click())

        val appCompatButton5 = onView(
                allOf(withId(R.id.start_anim_list), withText("开启帧动画"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()))
        appCompatButton5.perform(click())

        val appCompatButton6 = onView(
                allOf(withId(R.id.start_anim_list), withText("开启帧动画"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()))
        appCompatButton6.perform(click())

        val appCompatButton7 = onView(
                allOf(withId(R.id.dump), withText("dump"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()))
        appCompatButton7.perform(click())

        val appCompatButton8 = onView(
                allOf(withId(R.id.ObjectAnimator_btn), withText("ObjectAnimator"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()))
        appCompatButton8.perform(click())

        val appCompatButton9 = onView(
                allOf(withId(R.id.valueAnimator_btn), withText("valueAnimator"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()))
        appCompatButton9.perform(click())

        val appCompatButton10 = onView(
                allOf(withId(R.id.Interpolator_btn), withText("Interpolator"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()))
        appCompatButton10.perform(click())

        val appCompatButton11 = onView(
                allOf(withId(R.id.TypeEvaluator_btn), withText("TypeEvaluator"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()))
        appCompatButton11.perform(click())
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
