package com.ontotext.javacourse.designpatterns.calculator.commands;

import lombok.NoArgsConstructor;

/** The AddCommand class is a command that adds two given operands. */
@NoArgsConstructor
public class AddCommand implements Command {

  @Override
  public Double execute(Double firstOperand, Double secondOperand) {
    return firstOperand + secondOperand;
  }
}
