package com.ontotext.javacourse.intro.arrayprocessing;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class ArrayProcessingTest {
    private final int[] ARRAY = new int[]{3, -6, 1, -15, 26, 5};
    private final int[] EMPTY_ARRAY = new int[]{};

    @Test
    void getMinElementIndexWorksWithCorrectInput() {
        assertEquals(ArrayProcessing.getMinElementIndex(ARRAY), 3);
    }

    @Test
    void getMinElementIndexReturnsCorrectOutputWhenGivenEmptyArray() {
        assertEquals(ArrayProcessing.getMinElementIndex(EMPTY_ARRAY), -1);
    }

    @Test
    void sumWorksWithCorrectInput() {
        assertEquals(ArrayProcessing.sum(ARRAY), 14);
    }

    @Test
    void sumThrowsExceptionWhenArrayLengthIsZero() {
        assertThrows(InvalidParameterException.class, () -> ArrayProcessing.sum(EMPTY_ARRAY));
    }

    @Test
    void sumWithGivenIndexIntervalWorksWithCorrectInput() {
        assertEquals(ArrayProcessing.sum(ARRAY, 1, 4), -20);
    }

    @Test
    void printWorksWithCorrectInput() {
        assertEquals(ArrayProcessing.print(ARRAY), "3 -6 1 -15 26 5");
    }

    @Test
    void printWorksWithEmptyArrayInput() {
        assertEquals(ArrayProcessing.print(EMPTY_ARRAY), "");
    }

    @Test
    void findLargestSubarraySumWorksWithCorrectInput() {
        assertEquals(ArrayProcessing.findLargestSubarraySum(ARRAY), 31);
    }

    @Test
    void findLargestSubarraySumThrowsExceptionWithEmptyArrayInput() {
        assertThrows(IllegalArgumentException.class, () -> ArrayProcessing.findLargestSubarraySum(EMPTY_ARRAY));
    }

    @Test
    void swapElementsWorksWithCorrectInput() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ArrayProcessing.swapElements(array, 0, 4);
        assertEquals(array[0], 5);
        assertEquals(array[4], 1);
    }

    @Test
    void swapElementsThrowsExceptionWithInvalidIndexInput() {
        assertThrows(IllegalArgumentException.class, () -> ArrayProcessing.swapElements(ARRAY, -1, 2));
    }

    @Test
    void swapElementsThrowsExceptionWithEmptyArrayInput() {
        assertThrows(IllegalArgumentException.class, () -> ArrayProcessing.swapElements(EMPTY_ARRAY, 1, 2));
    }
}

