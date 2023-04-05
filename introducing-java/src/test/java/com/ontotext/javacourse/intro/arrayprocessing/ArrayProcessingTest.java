package com.ontotext.javacourse.intro.arrayprocessing;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayProcessingTest {
    private static final int[] ARRAY = new int[]{3, -6, 1, -15, 26, 5};
    private static final int[] EMPTY_ARRAY = new int[]{};

    @Test
    void getMinElementIndexWorksWithCorrectInput() {
        assertEquals(3, ArrayProcessing.getMinElementIndex(ARRAY));
    }

    @Test
    void getMinElementIndexReturnsCorrectOutputWhenGivenEmptyArray() {
        assertEquals(-1, ArrayProcessing.getMinElementIndex(EMPTY_ARRAY));
    }

    @Test
    void sumWorksWithCorrectInput() {
        assertEquals(14, ArrayProcessing.sum(ARRAY));
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
        assertEquals("3 -6 1 -15 26 5", ArrayProcessing.print(ARRAY));
    }

    @Test
    void printWorksWithEmptyArrayInput() {
        assertEquals("", ArrayProcessing.print(EMPTY_ARRAY));
    }

    @Test
    void findLargestSubarraySumWorksWithCorrectInput() {
        assertEquals(31, ArrayProcessing.findLargestSubarraySum(ARRAY));
    }

    @Test
    void findLargestSubarraySumThrowsExceptionWithEmptyArrayInput() {
        assertThrows(IllegalArgumentException.class, () -> ArrayProcessing.findLargestSubarraySum(EMPTY_ARRAY));
    }

    @Test
    void swapElementsWorksWithCorrectInput() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ArrayProcessing.swapElements(array, 0, 4);
        assertEquals(5, array[0]);
        assertEquals(1, array[4]);
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

