package com.ontotext.javacourse.intro.arraymedian;


/**
 * The ArrayMedian class contains a method which returns the position of the median of the array (The array median
 * is an element from the array from which the sum of the elements before and after the median are as close as possible)
 */
public final class ArrayMedian {

    /**
     * The findArrayMedian method takes a sequence of integers and returns the position of the median when counting
     * from one. Special cases:
     * <ul>
     *     <li> if the input sequence of integers has a length of zero, then the result is -1</li>
     * </ul>
     * Example:
     * ArrayMedian.findArrayMedian(1, 2, 3, 4, 5)  Result: 4 (element with index 3)
     * Params: sequence of integers - the numbers to find the median of
     * Result: the position of the median when counting from one
     */
    public static int findArrayMedian(int... numbers) {
        if (numbers.length == 0) {
            return -1;  /* special case */
        }
        int medianIndex = 0;
        int closestSumDifference = Integer.MAX_VALUE;

        for (int i = 1; i < numbers.length - 1; i++) {
            int leftSum = findSum(0, i, numbers);
            int rightSum = findSum(i + 1, numbers.length, numbers);

            if (Math.abs(leftSum - rightSum) < closestSumDifference) {
                closestSumDifference = Math.abs(leftSum - rightSum);
                medianIndex = i;
            }
        }
        return medianIndex + 1;
    }

    /**
     * The findSum method is a utility method used by findArrayMedian which finds the sum of the elements of a subarray
     * in a given array with given startIndex(inclusive) and endIndex(exclusive)
     * Params: startIndex - the subarray start index(inclusive)
     *         endIndex - the subarray end index(exclusive)
     *         array - the array of which subarray to find the sum of
     * Result: the sum of the subarray elements
     */
    private static int findSum(int startIndex, int endIndex, int[] array) {
        int sum = 0;

        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
        return sum;
    }


}
