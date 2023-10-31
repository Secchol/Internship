package com.ontotext.javacourse.designpatterns.calculator.commands;

import lombok.NoArgsConstructor;

/** The ExponentiateCommand class is a command that exponentiates two given operands. */
@NoArgsConstructor
public class ExponentiateCommand implements Command {
  @Override
  public Double execute(Double firstOperand, Double secondOperand) {
    return Math.pow(firstOperand, secondOperand);
  }
}
