package com.ontotext.javacourse.designpatterns.calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorAppTest {
  private CalculatorApp calculatorApp;

  @Test
  void startCalculatorExecutesUserOperationsCorrectly() {
    ByteArrayInputStream input = new ByteArrayInputStream("10\n1\n20\n6".getBytes());
    Calculator calculator = new Calculator();
    setUp(input, calculator);
    calculatorApp.startCalculator();
    assertEquals(30, calculator.getResult());
  }

  @ParameterizedTest
  @ValueSource(strings = {"0", "-2", "100"})
  void startCalculatorThrowsExceptionIfInvalidOperationNumberIsGiven(String operationNumber) {
    ByteArrayInputStream input =
        new ByteArrayInputStream(("10\n" + operationNumber + "\n20\n6").getBytes());
    setUp(input, new Calculator());
    assertThrows(InvalidParameterException.class, () -> calculatorApp.startCalculator());
  }

  private void setUp(InputStream inputStream, Calculator calculator) {
    System.setIn(inputStream);
    calculatorApp = new CalculatorApp(calculator);
  }
}
