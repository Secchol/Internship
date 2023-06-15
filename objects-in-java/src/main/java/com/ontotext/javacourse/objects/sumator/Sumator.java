package com.ontotext.javacourse.objects.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;

/**
 * The Sumator class contains methods for summing elements of type integer, double, string,
 * BigInteger and BigDecimal.
 */
public final class Sumator {

  private static final Logger LOGGER = Logger.getLogger(Sumator.class.getName());

  private Sumator() throws IllegalAccessException {
    throw new IllegalAccessException("Sumator class is not meant to be instantiated");
  }

  /**
   * Sums two integer numbers.
   *
   * @param firstNumber first number to sum
   * @param secondNumber second number to sum
   * @return sum of the firstNumber and secondNumber
   */
  public static int sum(int firstNumber, int secondNumber) {
    return firstNumber + secondNumber;
  }

  /**
   * Sums two floating point numbers.
   *
   * @param firstNumber first number to sum
   * @param secondNumber second number to sum
   * @return sum of the firstNumber and secondNumber
   */
  public static double sum(double firstNumber, double secondNumber) {
    return firstNumber + secondNumber;
  }

  /**
   * Sums two numbers given as string. The method can sum large numbers because it implements the
   * algorithm for summing used by people.
   *
   * @param firstNumber first number to sum
   * @param secondNumber second number to sum
   * @return sum of the firstNumber and secondNumber as string
   */
  public static String sum(String firstNumber, String secondNumber) {
    if (firstNumber.equals("") || secondNumber.equals("")) {
      throw new InvalidParameterException("String number cannot be empty");
    }
    BigInteger firstValue = new BigInteger(firstNumber);
    BigInteger secondValue = new BigInteger(secondNumber);
    return sum(firstValue, secondValue).toString();
  }

  /**
   * Sums two BigInteger objects.
   *
   * @param firstNumber first number to sum
   * @param secondNumber second number to sum
   * @return sum of the firstNumber and secondNumber
   */
  public static BigInteger sum(BigInteger firstNumber, BigInteger secondNumber) {
    return firstNumber.add(secondNumber);
  }

  /**
   * Sums two given BigDecimal objects.
   *
   * @param firstNumber first number to sum
   * @param secondNumber second number to sum
   * @return sum of the firstNumber and secondNumber
   */
  public static BigDecimal sum(BigDecimal firstNumber, BigDecimal secondNumber) {
    return firstNumber.add(secondNumber);
  }

  /**
   * Validates that the input numbers are numeric otherwise throws an exception.
   *
   * @param firstNumber the first number to sum
   * @param secondNumber the second number to sum
   * @throws InvalidParameterException if one of the numbers is non numeric
   */
  public static void validateInput(String firstNumber, String secondNumber) {
    try {
      if (!StringUtils.isNumeric(firstNumber) || !StringUtils.isNumeric(secondNumber)) {
        throw new InvalidParameterException("The given number is non numeric.");
      } else {
        Sumator.sum(firstNumber, secondNumber);
      }
    } catch (Exception exception) {
      LOGGER.info(exception.getMessage());
    }
  }
}
