package me.worric.databindingplayground;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String INPUT_TEXT = "test";

    @Rule
    public ActivityTestRule<MainActivity> mActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onAppLaunch_inputEditTextIsShown() {
        onView(withId(R.id.et_input_text))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onAppLaunch_buttonIsShown() {
        onView(withId(R.id.btn_process_text))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onAppLaunch_outputTextViewIsShown() {
        onView(withId(R.id.tv_output_text))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onButtonPress_processInputTextAndShowOutputText() {
        onView(withId(R.id.et_input_text))
                .perform(typeText(INPUT_TEXT));
        onView(withId(R.id.btn_process_text))
                .perform(click());
        onView(withId(R.id.tv_output_text))
                .check(matches(withText(INPUT_TEXT)));
    }

}