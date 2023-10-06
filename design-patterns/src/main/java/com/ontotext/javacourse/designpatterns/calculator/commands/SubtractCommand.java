package com.ontotext.javacourse.designpatterns.calculator.commands;

import com.ontotext.javacourse.designpatterns.calculator.Calculator;

/** The SubtractCommand class is a command that executes the subtraction operation. */
public class SubtractCommand extends BaseOperation {
  public SubtractCommand(Calculator calculator, double operand) {
    super(calculator, operand);
  }

  @Override
  public void execute() {
    super.getCalculator().subtract();
  }
}
