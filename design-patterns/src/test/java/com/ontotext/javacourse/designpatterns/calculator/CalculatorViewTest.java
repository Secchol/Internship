package com.ontotext.javacourse.designpatterns.calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class CalculatorViewTest {
  private CalculatorView calculatorView;

  @Test
  void promptNumberInputReturnsCorrectInputNumber() {
    ByteArrayInputStream input = new ByteArrayInputStream("10.22\n".getBytes());
    setUp(input);
    assertEquals(10.22, calculatorView.promptNumberInput());
  }

  @Test
  void promptOperationNumberReturnsCorrectInputNumber() {
    ByteArrayInputStream input = new ByteArrayInputStream("2\n".getBytes());
    setUp(input);
    assertEquals(2, calculatorView.promptOperationNumber());
  }

  private void setUp(InputStream inputStream) {
    System.setIn(inputStream);
    calculatorView = new CalculatorView();
  }
}
