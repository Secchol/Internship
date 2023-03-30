package com.ontotext.javacourse.intro.quicksort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class QuickSortTest {


    @Test
    void sortWorksWithCorrectInput() {
        assertEquals(QuickSort.sort(new int[]{5 ,4, 3, 2, 1}), "1 2 3 4 5");
    }

    @Test
    void sortWorksWithEmptyArrayInput() {
        assertEquals(QuickSort.sort(new int[]{}), "");
    }

}