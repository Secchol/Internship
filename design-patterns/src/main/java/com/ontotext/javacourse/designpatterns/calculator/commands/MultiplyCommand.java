package com.ontotext.javacourse.designpatterns.calculator.commands;

import com.ontotext.javacourse.designpatterns.calculator.Calculator;

/** The MultiplyCommand class is a command that executes the multiplication operation. */
public class MultiplyCommand extends BaseOperation {
  public MultiplyCommand(Calculator calculator, double operand) {
    super(calculator, operand);
  }

  @Override
  public void execute() {
    super.getCalculator().multiply();
  }
}
