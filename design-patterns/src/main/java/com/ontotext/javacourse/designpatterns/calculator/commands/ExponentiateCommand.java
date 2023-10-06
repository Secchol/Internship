package com.ontotext.javacourse.designpatterns.calculator.commands;

import com.ontotext.javacourse.designpatterns.calculator.Calculator;

/**
 * The ExponentiateCommand class is a command that raises the current result to a given exponent.
 */
public class ExponentiateCommand extends BaseOperation {
  public ExponentiateCommand(Calculator calculator, double operand) {
    super(calculator, operand);
  }

  @Override
  public void execute() {
    super.getCalculator().exponentiate();
  }
}
