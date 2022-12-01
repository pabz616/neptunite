package com.vergara.android.espressofirst;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureTextChangesWork(){
        //TYPE TEXT AND THEN PRESS THE BUTTON
        onView(withId(R.id.inputfield)).perform(typeText("Hello"), closeSoftKeyboard());
        onView(withId(R.id.changeText)).perform(click());

        //ASSERT THE TEXT WAS CHANGED
        onView(withId(R.id.inputfield)).check(matches(withText("Lalala")));
    }

    @Test
    public void changeText_newActivity(){
        //TYPE TEXT AND THEN PRESS THE BUTTON
        onView(withId(R.id.inputfield)).perform(typeText("New Text"), closeSoftKeyboard());
        onView(withId(R.id.switchActivity)).perform(click());

        //THIS VIEW IS IN A DIFFERENT ACTIVITY, NO NEED TO TELL ESPRESSO
        onView(withId(R.id.resultView)).check(matches(withText("NewText")));
    }
}
