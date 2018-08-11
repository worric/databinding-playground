package me.worric.databindingplayground;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String TEXT_VIEW_TEXT_HELLO_WORLD = "Hello World!";

    @Rule
    public ActivityTestRule<MainActivity> mActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onAppLaunch_textIsShown() {
        onView(withId(R.id.tv_output_text))
                .check(matches(withText(TEXT_VIEW_TEXT_HELLO_WORLD)));
    }

}