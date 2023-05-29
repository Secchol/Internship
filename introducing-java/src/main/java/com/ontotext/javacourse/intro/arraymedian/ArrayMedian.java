package com.ontotext.javacourse.intro.arraymedian;

import com.ontotext.javacourse.intro.arrayprocessing.ArrayProcessing;

/**
 * The ArrayMedian class contains a method which returns the position of the median of the array
 * (The array median is an element from the array from which the sum of the elements before and
 * after the median are as close as possible).
 */
public final class ArrayMedian {
  private ArrayMedian() throws IllegalAccessException {
    throw new IllegalAccessException("ArrayMedian class is not meant to be instantiated");
  }

  /**
   * Returns the position of the median of a given sequence of integers when counting from one.
   * Special cases:
   *
   * <ul>
   *   <li>if the input sequence of integers has a length of zero, then the result is -1
   * </ul>
   *
   * @param numbers - sequence of integers to find the median of
   * @return the position of the median when counting from one
   */
  public static int findArrayMedian(int... numbers) {
    if (numbers.length == 0) {
      return -1;
    }
    int medianIndex = 0;
    int closestSumDifference = Integer.MAX_VALUE;
    int leftSum = 0;
    int rightSum = ArrayProcessing.sum(numbers);

    for (int i = 1; i < numbers.length - 1; i++) {
      leftSum += numbers[i - 1];
      rightSum -= numbers[i];
      if (Math.abs(leftSum - rightSum) < closestSumDifference) {
        closestSumDifference = Math.abs(leftSum - rightSum);
        medianIndex = i;
      }
    }
    return medianIndex + 1;
  }
}
