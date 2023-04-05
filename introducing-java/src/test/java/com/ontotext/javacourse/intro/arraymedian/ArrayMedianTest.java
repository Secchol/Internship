package com.ontotext.javacourse.intro.arraymedian;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class ArrayMedianTest {

    @Test
    void findArrayMedianWorksWithCorrectInput() {
        assertEquals(ArrayMedian.findArrayMedian(4, 5, 99, -1, 5, 6), 3);
    }

    @Test
    void findArrayMedianWorksWithEmptyArrayInput() {
        assertEquals(ArrayMedian.findArrayMedian(), -1);
    }

    @Test
    void findArrayMedianWorksWithArrayWithLengthOneInput() {
        assertEquals(ArrayMedian.findArrayMedian(10), 1);
    }

    @Test
    void findArrayMedianWorksWithNegativeNumberArray() {
        assertEquals(ArrayMedian.findArrayMedian(-10, -20, -4, -3, -5, -6), 3);
    }
}