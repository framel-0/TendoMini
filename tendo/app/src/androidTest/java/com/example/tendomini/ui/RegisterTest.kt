package com.example.tendomini.ui


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.tendomini.R
import com.example.tendomini.ui.activities.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class RegisterTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun registerTest() {
        val materialTextView = onView(
            allOf(
                withId(R.id.textLoginSignUp), withText("Sign Up"),
                childAtPosition(
                    allOf(
                        withId(R.id.container),
                        childAtPosition(
                            withId(R.id.nav_host_fragment_activity_main),
                            0
                        )
                    ),
                    8
                ),
                isDisplayed()
            )
        )
        materialTextView.perform(click())

        val textInputEditText = onView(
            allOf(
                withId(R.id.editTextRegisterFullName),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.inputLayoutRegisterFullName),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("Frank Melo"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.editTextRegisterPhoneNumber),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.inputLayoutRegisterPhoneNumber),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("0240687954"), closeSoftKeyboard())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.editTextRegisterEmail),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.inputLayoutRegisterEmail),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(replaceText("melom"), closeSoftKeyboard())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.editTextRegisterEmail), withText("melom"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.inputLayoutRegisterEmail),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(click())

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.editTextRegisterEmail), withText("melom"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.inputLayoutRegisterEmail),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText5.perform(replaceText("melomeyfrank@gmail.com"))

        val textInputEditText6 = onView(
            allOf(
                withId(R.id.editTextRegisterEmail), withText("melomeyfrank@gmail.com"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.inputLayoutRegisterEmail),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText6.perform(closeSoftKeyboard())

        val textInputEditText7 = onView(
            allOf(
                withId(R.id.editTextRegisterPassword),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.inputLayoutRegisterPassword),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText7.perform(replaceText("password"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.buttonRegister), withText("Sign Up"),
                childAtPosition(
                    allOf(
                        withId(R.id.container),
                        childAtPosition(
                            withId(R.id.nav_host_fragment_activity_main),
                            0
                        )
                    ),
                    7
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

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
