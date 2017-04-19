package com.wojtek.bddaplication.test.steps;

import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created on 01.03.2017.
 *
 * @author Wojciech Szostak
 */

@SuppressWarnings("unused")
public class DefaultSteps extends BasicStep {

    @Then("^I enter text \"([^\"]*)\" into field with id \"([^\"]*)\"$")
    public void enterTextToEditTextWithId(String text, String id) throws NoSuchFieldException, IllegalAccessException {
        onView(withId(resolve(id))).perform(clearText(), typeText(text), closeSoftKeyboard());
    }

    @Given("^I press the \"([^\"]*)\" button$")
    public void pressButtonWithText(String text) {
        onView(withText(text)).perform(click());
    }

    @Then("^I see the text \"([^\"]*)\"$")
    public void seeText(String text) {
        onView(withText(text)).check(matches(isDisplayed()));
    }

}
