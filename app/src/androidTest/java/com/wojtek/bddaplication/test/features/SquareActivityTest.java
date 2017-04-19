package com.wojtek.bddaplication.test.features;

import android.support.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeConfig;
import com.mauriciotogneri.greencoffee.GreenCoffeeTest;
import com.mauriciotogneri.greencoffee.ScenarioConfig;
import com.wojtek.bddaplication.CircleActivity;
import com.wojtek.bddaplication.MainActivity;
import com.wojtek.bddaplication.test.steps.CircleActivityStep;
import com.wojtek.bddaplication.test.steps.DefaultSteps;
import com.wojtek.bddaplication.test.steps.SquareActivityStep;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;

/**
 * Created on 01.03.2017.
 *
 * @author Wojciech Szostak
 */

@SuppressWarnings("unused")
@RunWith(Parameterized.class)
public class SquareActivityTest extends GreenCoffeeTest {

    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class);

    public SquareActivityTest(ScenarioConfig scenario) {
        super(scenario);
    }

    @Parameterized.Parameters
    public static Iterable<ScenarioConfig> scenarios() throws IOException
    {
        return new GreenCoffeeConfig()
                .withFeatureFromAssets("assets/square.feature")
                .scenarios();
    }

    @Test
    public void test()
    {
        start(new DefaultSteps(), new SquareActivityStep());
    }

}
