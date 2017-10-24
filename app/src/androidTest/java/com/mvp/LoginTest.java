package com.mvp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mvp.view.LoginActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by atiq on 24/10/17.
 */

@RunWith(AndroidJUnit4.class)
public class LoginTest {


    private String mName;
    private String mPassword;
    private String mSuccessString;


    @Rule
    public ActivityTestRule<LoginActivity> mainActivityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void initVariables(){

        mName = "Atiq";
        mPassword = "alam";
        mSuccessString = "User Login Successfully !";
    }

    @Test
    public void test1CheckRegisterSuccess(){

        onView(withId(R.id.username)).perform(typeText(mName));

        closeSoftKeyboard();

        onView(withId(R.id.password)).perform(typeText(mPassword));

        closeSoftKeyboard();

        onView(withId(R.id.button)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(mSuccessString))).check(matches(isDisplayed()));

    }



    @Test
    public void test2emptyUsername(){

        onView(withId(R.id.username)).perform(typeText(mName));

        closeSoftKeyboard();

        onView(withId(R.id.password)).perform(typeText(mPassword));

        closeSoftKeyboard();

        onView(withId(R.id.button)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("Username is empty"))).check(matches(isDisplayed()));
    }

    @Test
    public void test3emptyUsernameLength(){

        onView(withId(R.id.username)).perform(typeText(mName));

        closeSoftKeyboard();

        onView(withId(R.id.password)).perform(typeText(mPassword));

        closeSoftKeyboard();

        onView(withId(R.id.button)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("Username should be 4 or more character"))).check(matches(isDisplayed()));
    }
    @Test
    public void test3emptyUsernameSpace(){

        onView(withId(R.id.username)).perform(typeText(mName));

        closeSoftKeyboard();

        onView(withId(R.id.password)).perform(typeText(mPassword));

        closeSoftKeyboard();

        onView(withId(R.id.button)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("Username contains space"))).check(matches(isDisplayed()));
    }




    @Test
    public void test4emptyPassword(){

        onView(withId(R.id.username)).perform(typeText(mName));

        closeSoftKeyboard();

        onView(withId(R.id.password)).perform(typeText(mPassword));

        closeSoftKeyboard();

        onView(withId(R.id.button)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("password is empty"))).check(matches(isDisplayed()));
    }

    @Test
    public void test5emptyPasswordLength(){

        onView(withId(R.id.username)).perform(typeText(mName));

        closeSoftKeyboard();

        onView(withId(R.id.password)).perform(typeText(mPassword));

        closeSoftKeyboard();

        onView(withId(R.id.button)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("password should be 4 or more character"))).check(matches(isDisplayed()));
    }
    @Test
    public void test6emptyPasswordSpace(){

        onView(withId(R.id.username)).perform(typeText(mName));

        closeSoftKeyboard();

        onView(withId(R.id.password)).perform(typeText(mPassword));

        closeSoftKeyboard();

        onView(withId(R.id.button)).perform(click());

        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("password contains space"))).check(matches(isDisplayed()));
    }



}
