package com.ontotext.javacourse.designpatterns.calculator.commands;

import lombok.NoArgsConstructor;

/** The SubtractCommand class is a command that subtracts two given operands. */
@NoArgsConstructor
public class SubtractCommand implements Command {
  @Override
  public Double execute(Double firstOperand, Double secondOperand) {
    return firstOperand - secondOperand;
  }
}
