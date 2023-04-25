package com.ontotext.javacourse.intro.quicksort;

import com.ontotext.javacourse.intro.arrayprocessing.ArrayProcessing;

/**
 * The QuickSort class provides a single method sort which sorts a given integer array in ascending order and
 * displays the result to the screen
 */
public final class QuickSort {

    private QuickSort() throws IllegalAccessException {
        throw new IllegalAccessException("QuickSort class is not meant to be instantiated");
    }

    /**
     * Sorts the given method(by calling the quickSort method) and displays the sorted method to the screen
     *
     * @param array the array to be sorted
     */
    public static String sort(int[] array) {
        QuickSort.quickSort(array, 0, array.length - 1);
        return ArrayProcessing.print(array);
    }

    /**
     * Sorts the given array from the startIndex to the endIndex in ascending order.
     *
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
     * Sorts the given array from startIndex to endIndex and returns the
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
                ArrayProcessing.swapElements(array, i, j);
            }
        }
        ArrayProcessing.swapElements(array, i + 1, endIndex);
        return i + 1;
    }
}
