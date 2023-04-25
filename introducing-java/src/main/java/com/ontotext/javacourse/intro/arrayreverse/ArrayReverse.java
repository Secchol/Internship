package com.ontotext.javacourse.intro.arrayreverse;

import com.ontotext.javacourse.intro.arrayprocessing.ArrayProcessing;

/**
 * The ArrayReverse class contains a method which reverses a given integer array
 */
public final class ArrayReverse {
    private ArrayReverse() throws IllegalAccessException {
        throw new IllegalAccessException("ArrayReverse class is not meant to be instantiated");
    }

    /**
     * Reverses a given integer array
     * @param array the array to be reversed
     */
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            ArrayProcessing.swapElements(array, i, array.length - 1 - i);
        }
    }
}
