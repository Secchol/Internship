package com.ontotext.javacourse.intro.gcd;

/**
 * The class GCDandLCM contains two methods FindGCD and FindLCM used for finding the Greatest common divisor(GCD)
 * of two integers and the Least common multiple(LCM) of two integers.
 */
public final class GCDandLCM {
    private GCDandLCM() throws IllegalAccessException {
        throw new IllegalAccessException("GCDandLCM class is not meant to be instantiated");
    }

    /**
     * Returns the Greatest common divisor(GCD) of two integers
     * Example:
     * GCDandLCM.findGCD(5,10)  Result: 5
     * @param firstNumber  the first number
     * @param secondNumber the second number
     * @return gcd of firstNumber and secondNumber
     */
    public static int findGCD(int firstNumber, int secondNumber) {
        int smallerNum = Math.min(firstNumber, secondNumber);
        int gcd = 0;

        for (int i = 1; i <= smallerNum; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                gcd = i;
            }
        }
        if (gcd == 0) {
            gcd = (firstNumber == 0) ? secondNumber : firstNumber;
        }
        return gcd;
    }

    /**
     * The findLCM method depends on the findGCD method and returns the least common multiple of two integers
     * Example:
     * GCDandLCM.findLCM(20,30)  Result: 60
     * @param firstNumber  the first number
     * @param secondNumber the second number
     * @return gcd of firstNumber and secondNumber
     * @throws IllegalArgumentException if either a or b is zero
     */
    public static int findLCM(int firstNumber, int secondNumber) {
        if (firstNumber == 0 || secondNumber == 0) {
            throw new IllegalArgumentException("Method parameter cannot be zero");
        }
        return (firstNumber * secondNumber) / (findGCD(firstNumber, secondNumber));
    }


}
