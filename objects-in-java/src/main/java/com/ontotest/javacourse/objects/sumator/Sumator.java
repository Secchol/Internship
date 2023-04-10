package com.ontotest.javacourse.objects.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidParameterException;

public class Sumator {

    private Sumator() throws IllegalAccessException {
        throw new IllegalAccessException("Sumator class is not meant to be instantiated");
    }

    /**
     * Sums two integer numbers.
     *
     * @param firstNumber  first number to sum
     * @param secondNumber second number to sum
     * @return sum of the firstNumber and secondNumber
     */
    public static int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    /**
     * Sums two floating point numbers.
     *
     * @param firstNumber  first number to sum
     * @param secondNumber second number to sum
     * @return sum of the firstNumber and secondNumber
     */
    public static double sum(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    /**
     * Sums two numbers given as string. The method can sum large numbers because it implements the algorithm
     * for summing used by people.
     *
     * @param firstNumber  first number to sum
     * @param secondNumber second number to sum
     * @return sum of the firstNumber and secondNumber as string
     */
    public static String sum(String firstNumber, String secondNumber) {
        if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
            throw new InvalidParameterException("Input number cannot be empty");
        }

        firstNumber = removeLeadingZeroes(firstNumber);
        secondNumber = removeLeadingZeroes(secondNumber);
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

        //Adds remaining digits of larger number
        String largerNumber = firstNumber.length() > secondNumber.length() ? firstNumber : secondNumber;
        for (int i = shorterNumber.length(); i < largerNumber.length(); i++) {
            int leftoverSum = Integer.parseInt(String.valueOf(largerNumber.charAt(i))) + remainder;
            remainder = leftoverSum / 10;
            int resultDigit = leftoverSum % 10;
            sum.append(resultDigit);
        }

        //Adds remaining remainder if there is such
        if (remainder > 0) {
            sum.append(remainder);
        }
        return sum.reverse().toString();

    }

    /**
     * Removes leading zeroes of a number if there are such.
     *
     * @param number the number to remove leading zeroes from
     * @return the number with removed leading zeroes
     */
    private static String removeLeadingZeroes(String number) {
        if (number.charAt(0) == '0') {
            int endIndex = 0;
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) != '0') {
                    endIndex = i;
                    break;
                }
            }
            number = endIndex == 0 ? "0" : number.substring(endIndex);
        }
        return number;
    }

    /**
     * Sums two BigInteger objects.
     *
     * @param firstNumber  first number to sum
     * @param secondNumber second number to sum
     * @return sum of the firstNumber and secondNumber
     */
    public static BigInteger sum(BigInteger firstNumber, BigInteger secondNumber) {
        return firstNumber.add(secondNumber);
    }

    /**
     * Sums two given BigDecimal objects.
     *
     * @param firstNumber  first number to sum
     * @param secondNumber second number to sum
     * @return sum of the firstNumber and secondNumber
     */
    public static BigDecimal sum(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.add(secondNumber);
    }
}
