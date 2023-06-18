package com.ontotext.javacourse.objects.sumator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

class SumatorTest {

  @Test
  void sumIntegersWorksWithCorrectInput() {
    assertEquals(100, Sumator.sum(60, 40));
  }

  @Test
  void sumIntegersWorksWithZeroAsInputInput() {
    assertEquals(0, Sumator.sum(0, 0));
  }

  @Test
  void sumFloatingPointNumbersWorksWithCorrectInput() {
    assertEquals(200.72, Sumator.sum(96.26, 104.46));
  }

  @Test
  void sumFloatingPointNumbersWorksWithZeroAsInput() {
    assertEquals(0, Sumator.sum(0, 0));
  }

  @Test
  void sumStringsWorksWithEqualLengthNumbersInput() {
    assertEquals("1045", Sumator.sum("157", "888"));
  }

  @Test
  void sumStringsWorksWithDifferentLengthNumbersInput() {
    assertEquals("15788311", Sumator.sum("15787423", "888"));
  }

  @Test
  void sumStringsWorksWithLongNumbersInput() {
    assertEquals("281219555843646", Sumator.sum("157874231311123", "123345324532523"));
  }

  @Test
  void sumStringsWorksWithEmptyZeroInput() {
    assertEquals("0", Sumator.sum("0", "0"));
  }

  @Test
  void sumStringsThrowsExceptionWithEmptyStringInput() {
    assertThrows(InvalidParameterException.class, () -> Sumator.sum("", "123"));
  }

  @Test
  void sumStringsThrowsExceptionWithNonNumericInput() {
    assertThrows(InvalidParameterException.class, () -> Sumator.sum("$asd23", "123"));
  }

  @Test
  void sumStringsWorksWithTrailingZeroesNumberInput() {
    assertEquals("99999", Sumator.sum("99999", "000000000"));
    assertEquals("100000", Sumator.sum("99999", "000000001"));
  }

  @Test
  void sumBigIntegerWorksWithCorrectInput() {
    BigInteger expectedSum = BigInteger.valueOf(24);
    BigInteger firstNumber = BigInteger.valueOf(10);
    BigInteger secondNumber = BigInteger.valueOf(14);
    assertEquals(expectedSum, Sumator.sum(firstNumber, secondNumber));
  }

  @Test
  void sumBigIntegerWorksWithBigNumbersInput() {
    BigInteger expectedSum = new BigInteger("131020205065");
    BigInteger firstNumber = new BigInteger("123123123123");
    BigInteger secondNumber = new BigInteger("7897081942");
    assertEquals(expectedSum, Sumator.sum(firstNumber, secondNumber));
  }

  @Test
  void sumBigDecimalWorksWithCorrectInput() {
    BigDecimal expectedSum = BigDecimal.valueOf(24.3467);
    BigDecimal firstNumber = BigDecimal.valueOf(10.1231);
    BigDecimal secondNumber = BigDecimal.valueOf(14.2236);
    assertEquals(expectedSum, Sumator.sum(firstNumber, secondNumber));
  }

  @Test
  void sumBigDecimalWorksWithBigNumbersInput() {
    BigDecimal expectedSum = new BigDecimal("1367.5814180155094");
    BigDecimal firstNumber = new BigDecimal("1245.342423123123");
    BigDecimal secondNumber = new BigDecimal("122.2389948923864");
    assertEquals(expectedSum, Sumator.sum(firstNumber, secondNumber));
  }
}
