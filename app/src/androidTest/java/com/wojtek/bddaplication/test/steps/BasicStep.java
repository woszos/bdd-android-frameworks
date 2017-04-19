package com.wojtek.bddaplication.test.steps;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.wojtek.bddaplication.R;

import java.lang.reflect.Field;

/**
 * Created on 01.03.2017.
 *
 * @author Wojciech Szostak
 */

@SuppressWarnings("unused")
public class BasicStep extends GreenCoffeeSteps {

    public int resolve(String id) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = R.id.class;
        Field field = clazz.getField(id);

        return field.getInt(field);
    }

}
