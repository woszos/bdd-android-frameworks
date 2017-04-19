package com.wojtek.bddaplication;

/**
 * Created on 28.02.2017.
 *
 * @author Wojciech Szostak
 */

public interface OnSquareListener {

    void onSuccess(int squareOfArea);
    void onFailed(int error);

}
