package com.ontotext.javacourse.designpatterns.calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RPNEvaluatorTest {

  @Test
  void getReversePolishNotationReturnsRPNOfExpressionCorrectly() {
    assertEquals(
        List.of("1", "3", "+", "4", "/"),
        RPNEvaluator.getReversePolishNotation(List.of("(", "1", "+", "3", ")", "/", "4")));
  }

  @Test
  void getReversePolishNotationThrowsExceptionIfParenthesisIsLeftOpen() {
    assertThrows(
        IllegalArgumentException.class,
        () -> RPNEvaluator.getReversePolishNotation(List.of("(", "1", "+", "3")));
  }

  @Test
  void getReversePolishNotationThrowsExceptionIfExpressionIsEmpty() {
    assertThrows(
        IllegalArgumentException.class, () -> RPNEvaluator.getReversePolishNotation(List.of()));
  }
}
