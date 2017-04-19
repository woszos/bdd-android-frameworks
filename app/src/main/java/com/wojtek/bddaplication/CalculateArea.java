package com.wojtek.bddaplication;

import android.support.annotation.NonNull;

/**
 * Created on 28.02.2017.
 *
 * @author Wojciech Szostak
 */

public class CalculateArea {

    public double areaOfCircle(int radius) {
        if (radius >= 0) {
            return Math.PI * Math.pow(radius, 2);
        }

        return -1.0;
    }

    public int volumeCuboid(int valueL, int valueH, int valueW) {
        if (valueL < 0) {
            return -1;
        }
        if (valueH < 0) {
            return -2;
        }
        if (valueW < 0) {
            return -3;
        }
        return valueL * valueH * valueW;
    }

    public void areaOfSquare(int valueX, int valueY, @NonNull OnSquareListener listener) {
        boolean failed = false;
        if (valueX < 0) {
            listener.onFailed(-1);
            failed = true;
        }
        if (valueY < 0) {
            listener.onFailed(-1);
            failed = true;
        }

        if (!failed) {
            listener.onSuccess(valueX * valueY);
        }
    }
}
