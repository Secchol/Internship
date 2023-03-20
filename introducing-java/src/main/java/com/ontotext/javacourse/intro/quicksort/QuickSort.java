package com.ontotext.javacourse.intro.quicksort;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * The QuickSort class provides a single method sort which sorts a given integer array in ascending order and
 * displays the result to the screen
 */
public final class QuickSort {

    private static final Logger LOGGER = Logger.getLogger(QuickSort.class.getName());

    /**
     * The sort method sorts the given method(by calling the quickSort method) and displays the sorted method to the screen
     * Example:
     * QuickSort.sort(new int[] {5, 2, 3, 1, 4})  Prints: {1, 2, 3, 4, 5}
     * Params: int[] array - the array to be sorted
     */
    public static void sort(int[] array) {
        QuickSort.quickSort(array, 0, array.length - 1);
        LOGGER.info(Arrays.toString(array));
    }

    /**
     * The quickSort method sorts the given array from the startIndex to the endIndex in ascending order.
     * @param array      the array to be sorted
     * @param startIndex the start index of the subarray
     * @param endIndex   the end index of the subarray
     */
    private static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = findPivotIndex(array, startIndex, endIndex);

            QuickSort.quickSort(array, startIndex, pivotIndex - 1);
            QuickSort.quickSort(array, pivotIndex + 1, endIndex);
        }
    }

    /**
     * The findPivotIndex sorts the given array from startIndex to endIndex and returns the
     * index of the array pivot.
     *
     * @param array      the array to be sorted
     * @param startIndex the start index of the subarray
     * @param endIndex   the end index of the subarray
     * @return the index of the array pivot
     */
    private static int findPivotIndex(int[] array, int startIndex, int endIndex) {
        int pivot = array[endIndex];
        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++) {
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i + 1];
        array[i + 1] = array[endIndex];
        array[endIndex] = swapTemp;
        return i + 1;
    }
}
