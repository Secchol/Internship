package com.ontotext.javacourse.intro.arrayprocessing;

import org.junit.jupiter.api.Test;

import java.awt.dnd.InvalidDnDOperationException;
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
    void printWorksWithCorrectInput() {
        //assert that correct input is displayed
    }

    @Test
    void findLargestSubarraySumWorksWithCorrectInput() {
        //assert that correct input is displayed
    }

    @Test
    void findLargestSubarraySumThrowsExceptionWithEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> ArrayProcessing.findLargestSubarraySum(EMPTY_ARRAY));
    }
}

