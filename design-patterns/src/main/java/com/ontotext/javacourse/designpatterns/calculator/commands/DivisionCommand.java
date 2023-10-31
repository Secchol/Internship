package com.ontotext.javacourse.designpatterns.calculator.commands;

import lombok.NoArgsConstructor;

/** The DivisionCommand class is a command that divides two given operands. */
@NoArgsConstructor
public class DivisionCommand implements Command {

  @Override
  public Double execute(Double firstOperand, Double secondOperand) {
    if (secondOperand == 0) {
      throw new IllegalArgumentException("Division by zero!");
    }
    return firstOperand / secondOperand;
  }
}
