package com.wojtek.bddaplication.test.steps;

import com.mauriciotogneri.greencoffee.annotations.Then;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created on 01.03.2017.
 *
 * @author Wojciech Szostak
 */

@SuppressWarnings("unused")
public class CircleActivityStep extends BasicStep {

    @Then("^I clear \"([^\"]*)\"$")
    public void clearEditTex(String id) throws NoSuchFieldException, IllegalAccessException {
        onView(withId(resolve(id))).perform(clearText());
    }

}
