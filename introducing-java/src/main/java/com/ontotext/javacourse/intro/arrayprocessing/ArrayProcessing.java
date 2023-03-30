package com.ontotext.javacourse.intro.arrayprocessing;

import java.security.InvalidParameterException;

/**
 * The ArrayProcessing class provides the implementation of four methods
 * that take an array of integers as input and perform different actions based on its elements
 */
public final class ArrayProcessing {

    private ArrayProcessing() throws IllegalAccessException {
        throw new IllegalAccessException("ArrayProcessing class is not meant to be instantiated");
    }

    /**
     * Returns the index of the element with the minimum value of a given array. Special cases:
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
            return -1;
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
     * Sums all elements in a given array.
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
     * Returns the sum of the elements of a subarray in a given array with given startIndex(inclusive)
     * and endIndex(exclusive)
     * Params: startIndex - the subarray start index(inclusive)
     *         endIndex - the subarray end index(exclusive)
     *         array - the array of which subarray to find the sum of
     * Result: the sum of the subarray elements
     */
    public static int sum(int[] array, int startIndex, int endIndex) {
        int sum = 0;

        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Returns all the elements in a given array separated by " ".
     * Example:
     * int[] array = new int[]{-3, 4, 6, -10, 13};
     * ArrayProcessing.sum(array)  Result: "-3, 4, 6, -10, 13"
     * Params: int[] array - the array to be printed
     * Returns: all the elements in the given array separated by " "
     */
    public static String print(int[] array) {
        StringBuilder arrayElements = new StringBuilder();
        for (int element : array) {
            arrayElements.append(element);
            arrayElements.append(" ");
        }
        return arrayElements.toString().trim();
    }

    /**
     * Finds the contiguous subarray with the largest sum and returns the sum.
     * Example:
     * int[] array = new int[]{-3, 4, 6, -10, 13, 10};
     * ArrayProcessing.findLargestSubarraySum(array)  Result: "23"
     * Params: int[] array - the array of which to find the contiguous subarray with the largest sum
     * Returns: the largest sum of a contiguous subarray
     * Throws: InvalidParameterException - if the given array is empty(length == 0)
     */
    public static int findLargestSubarraySum(int[] array) {
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
        return maxSum;
    }

    /**
     * Swaps two elements in a given array.
     * @param array the array in which to swap two elements
     * @param firstElementIndex the index of the first element
     * @param secondElementIndex the index of the second element
     * @throws IllegalArgumentException if the given index is invalid(less than zero) or the
     * given array is empty(length == 0)
     */
    public static void swapElements(int[] array, int firstElementIndex, int secondElementIndex) {
        if (firstElementIndex < 0 || secondElementIndex < 0) {
            throw new IllegalArgumentException("Invalid index");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        int swapTemp = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = swapTemp;
    }
}

