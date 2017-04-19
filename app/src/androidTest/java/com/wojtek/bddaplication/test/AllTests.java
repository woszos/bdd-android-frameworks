package com.wojtek.bddaplication.test;

import com.wojtek.bddaplication.test.features.CircleActivityTest;
import com.wojtek.bddaplication.test.features.SquareActivityTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created on 01.03.2017.
 *
 * @author Wojciech Szostak
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CircleActivityTest.class,
        SquareActivityTest.class
})
public class AllTests {
}
