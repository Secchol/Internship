package com.ontotext.javacourse.intro.sumnumbers;

import java.security.InvalidParameterException;

/**
 * The SumNumbers class contains a method can sum two large numbers both given as strings
 */
public final class SumNumbers {
    private SumNumbers() throws IllegalAccessException {
        throw new IllegalAccessException("SumNumbers class is not meant to be instantiated");
    }

    /**
     * Sums two numbers given as strings that can have unlimited length. The sum method is used for summing
     * large numbers because it implements the algorithm for summing.
     * @param firstNumber  the first number to sum
     * @param secondNumber the second number to sum
     * @return sum of firstNumber and secondNumber as a string
     */
    public static String sum(String firstNumber, String secondNumber) {
        if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
            throw new InvalidParameterException("Input number cannot be empty");
        }
        StringBuilder sum = new StringBuilder();
        String shorterNumber = firstNumber.length() < secondNumber.length() ? firstNumber : secondNumber;
        firstNumber = new StringBuilder(firstNumber).reverse().toString();
        secondNumber = new StringBuilder(secondNumber).reverse().toString();
        int remainder = 0;
        for (int i = 0; i < shorterNumber.length(); i++) {
            int firstNumberDigit = Integer.parseInt(String.valueOf(firstNumber.charAt(i)));
            int secondNumberDigit = Integer.parseInt(String.valueOf(secondNumber.charAt(i)));
            int result = firstNumberDigit + secondNumberDigit + remainder;
            remainder = result / 10;
            int resultDigit = result % 10;
            sum.append(resultDigit);
        }

        /*Adds remaining digits of larger number*/
        String largerNumber = firstNumber.length() > secondNumber.length() ? firstNumber : secondNumber;
        for (int i = shorterNumber.length(); i < largerNumber.length(); i++) {
            int leftoverSum = Integer.parseInt(String.valueOf(largerNumber.charAt(i))) + remainder;
            remainder = leftoverSum / 10;
            int resultDigit = leftoverSum % 10;
            sum.append(resultDigit);
        }

        /*Adds remaining remainder if there is such*/
        if (remainder > 0) {
            sum.append(remainder);
        }
        return sum.reverse().toString();
    }

}
