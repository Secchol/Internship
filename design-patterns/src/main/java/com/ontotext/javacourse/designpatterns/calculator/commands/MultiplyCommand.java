package com.ontotext.javacourse.designpatterns.calculator.commands;

import lombok.NoArgsConstructor;

/** The MultiplyCommand class is a command that multiplies two given operands. */
@NoArgsConstructor
public class MultiplyCommand implements Command {
  @Override
  public Double execute(Double firstOperand, Double secondOperand) {
    return firstOperand * secondOperand;
  }
}
