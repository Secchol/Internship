package com.ontotext.javacourse.intro.arrayprocessing;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * The ArrayProcessing class provides the implementation of four methods
 * that take an array of integers as input and perform different actions based on its elements
 */
public final class ArrayProcessing {

    private final static Logger LOGGER = Logger.getLogger(ArrayProcessing.class.getName());

    /**
     * The getMinElementIndex method returns the index of the element with the minimum value
     * of a given array.Special cases:
     * <ul>
     *     <li>if array is empty(length==0), then the result is -1</li>
     * </ul>
     * Example:
     * int[] array = new int[]{-3, 4, 6, -10, 13};
     * ArrayProcessing.getMinElementIndex(array)  Result: 3
     * Params: int[] array - the array in which to find the min element index
     * Result: the index of the element with the minimum value
     */
    public static int getMinElementIndex(int[] array) {
        if (array.length == 0) {
            return -1;  /*special case*/
        }
        int minElementIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[minElementIndex]) {
                minElementIndex = i;
            }
        }
        return minElementIndex;
    }

    /**
     * The sum method returns the sum of all elements in a given array.
     * Example:
     * int[] array = new int[]{-3, 4, 6, -10, 13};
     * ArrayProcessing.sum(array)  Result: 10
     * Params: int[] array - the array to find the sum of
     * Result: the sum of all elements in a given array
     * Throws: InvalidParameterException - if the given array is empty(length==0)
     */
    public static int sum(int[] array) {
        if (array.length == 0) {
            throw new InvalidParameterException("Array length cannot be zero");
        }
        int sum = 0;

        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    /**
     * The print method prints all the elements in a given array to the screen
     * Example:
     * int[] array = new int[]{-3, 4, 6, -10, 13};
     * ArrayProcessing.sum(array)  Prints: "-3, 4, 6, -10, 13"
     * Params: int[] array - the array to be printed
     */
    public static void print(int[] array) {
        LOGGER.info(Arrays.toString(array));
    }

    /**
     * The findLargestSubarraySum method finds the contiguous subarray with the largest sum
     * and prints the sum to the screen.
     * Example:
     * int[] array = new int[]{-3, 4, 6, -10, 13, 10};
     * ArrayProcessing.findLargestSubarraySum(array)  Prints: "23"
     * Params: int[] array - the array of which to find the contiguous subarray with the largest sum
     * Throws: InvalidParameterException - if the given array is empty(length==0)
     */
    public static void findLargestSubarraySum(int[] array) {
        if (array.length == 0) {
            throw new InvalidParameterException("Array length cannot be zero");
        }
        int maxSum = Integer.MIN_VALUE;
        int currentSubarraySum = 0;

        for (int i = 0; i <= array.length - 1; i++) {
            currentSubarraySum += array[i];
            if (currentSubarraySum > maxSum) {
                maxSum = currentSubarraySum;
            }
            if (currentSubarraySum < 0) {
                currentSubarraySum = 0;
            }
        }
        LOGGER.info(Integer.toString(maxSum));
    }
}

