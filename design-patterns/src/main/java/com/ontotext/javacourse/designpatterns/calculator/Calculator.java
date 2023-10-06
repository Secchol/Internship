package com.ontotext.javacourse.designpatterns.calculator;

import lombok.NoArgsConstructor;

/**
 * Defines a calculator that can perform addition,subtraction,multiplication,division and
 * exponentiation and return the result.
 */
@NoArgsConstructor
public class Calculator {
  private double result;
  private double operand;

  public void setOperand(double operand) {
    this.operand = operand;
  }

  public void add() {
    result += operand;
  }

  public void subtract() {
    result -= operand;
  }

  public void multiply() {
    result *= operand;
  }

  /** Divides the result by the given operand if the divisor is not zero. */
  public void divide() {
    if (operand == 0) {
      System.out.println("Division by zero!");
    } else {
      result /= operand;
    }
  }

  public void exponentiate() {
    result = Math.pow(result, operand);
  }

  public double getResult() {
    return this.result;
  }
}
