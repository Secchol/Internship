package com.ontotext.javacourse.intro.gcd;

/**
 * The class GCDandLCM contains two methods FindGCD and FindLCM used for finding the Greatest common divisor(GCD)
 * of two integers and the Least common multiple(LCM) of two integers.
 */
public final class GCDandLCM {
    private GCDandLCM() {

    }

    /**
     * The findGCD method returns the Greatest common divisor(GCD) of two integers
     * Example:
     * GCDandLCM.findGCD(5,10)  Result: 5
     * Params: a,b both integers
     * Result: the greatest common divisor of a and b
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
            gcd = firstNumber == 0 ? secondNumber : firstNumber;
        }
        return gcd;
    }

    /**
     * The findLCM method depends on the findGCD method and returns the least common multiple of two integers
     * Example:
     * GCDandLCM.findLCM(20,30)  Result: 60
     * Params: a,b both integers
     * Result: the least common multiple of a and b
     * Throws: IllegalArgumentException-if either a or b is zero
     */
    public static int findLCM(int firstNumber, int secondNumber) {
        if (firstNumber == 0 || secondNumber == 0) {
            throw new IllegalArgumentException("Method parameter cannot be zero");
        }
        return (firstNumber * secondNumber) / (findGCD(firstNumber, secondNumber));
    }


}
