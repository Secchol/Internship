package com.ontotext.javacourse.intro.arrayreverse;

import com.ontotext.javacourse.intro.arrayprocessing.ArrayProcessing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ArrayReverseTest {

    @Test
    void reverseWorksWithOddLengthArrayInput() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ArrayReverse.reverse(array);
        assertEquals("5 4 3 2 1", ArrayProcessing.print(array));
    }

    @Test
    void reverseWorksWithEvenLengthArrayInput() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        ArrayReverse.reverse(array);
        assertEquals("6 5 4 3 2 1", ArrayProcessing.print(array));
    }

    @Test
    void reverseWorksWithEvenEmptyArrayInput() {
        int[] emptyArray = new int[]{};
        ArrayReverse.reverse(emptyArray);
        assertEquals("", ArrayProcessing.print(emptyArray));
    }
}