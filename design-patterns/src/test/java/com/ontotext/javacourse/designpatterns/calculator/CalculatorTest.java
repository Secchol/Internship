package com.ontotext.javacourse.designpatterns.calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  void evaluateExpressionReturnsCorrectExpressionResult() {
    assertEquals(1296, Calculator.evaluateExpression(List.of("10", "2", "+", "3", "*", "2", "^")));
  }

  @Test
  void evaluateExpressionThrowsExceptionWhenDivisionByZero() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Calculator.evaluateExpression(List.of("2", "0", "/")));
  }
}
