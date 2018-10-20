package me.worric.databindingplayground;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String INPUT_TEXT = "test";

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
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

    /**
     * See <a href="https://stackoverflow.com/a/51907217/8562738">this post</a> for an explanation of
     * why we need to match a Toast message in this way
     */
    @Test
    public void onButtonPress_ToastWithTextIsShown() {
        String expectedText = mActivityTestRule.getActivity().getResources()
                .getString(R.string.toast_main_message);

        onView(withId(R.id.btn_trigger_notification))
                .perform(click());
        onView(withText(expectedText))
                .inRoot(withDecorView(not(mActivityTestRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onButtonPress_nonDefaultValuesAreShown() {
        String nameErrorText = mActivityTestRule.getActivity().getResources()
                .getString(R.string.error_msg_main_no_coffee_chosen);
        String numberErrorText = String.valueOf(0);

        onView(withId(R.id.btn_fetch_coffee))
                .perform(click());
        onView(withId(R.id.tv_coffee_name))
                .check(matches(not(withText(nameErrorText))));
        onView(withId(R.id.tv_coffee_number))
                .check(matches(not(withText(numberErrorText))));
    }

}