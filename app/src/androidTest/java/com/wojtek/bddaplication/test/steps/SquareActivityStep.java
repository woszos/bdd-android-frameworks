package com.wojtek.bddaplication.test.steps;

import com.mauriciotogneri.greencoffee.annotations.Then;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created on 01.03.2017.
 *
 * @author Wojciech Szostak
 */

@SuppressWarnings("unused")
public class SquareActivityStep extends BasicStep {

    @Then("^I press view with id \"([^\"]*)\"$")
    public void pressViewWithId(String id) throws NoSuchFieldException, IllegalAccessException {
        onView(withId(resolve(id))).perform(click());

    }

}
