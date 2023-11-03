package com.ontotext.javacourse.designpatterns.calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class CalculatorAppTest {
  private CalculatorApp calculatorApp;
  private ByteArrayOutputStream outputStream;

  @Test
  void startCalculatorTakesInputAndDisplaysExpressionResultCorrectly() {
    setUp("( 2 + 10 ) * 3 / 2");
    calculatorApp.startCalculator();
    String consoleOutput = outputStream.toString().trim();
    assertTrue(consoleOutput.contains("18.00"));
  }

  private void setUp(String inputString) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    outputStream = new ByteArrayOutputStream();
    System.setIn(inputStream);
    System.setOut(new PrintStream(outputStream));
    calculatorApp = new CalculatorApp();
  }
}
