package com.ontotext.javacourse.designpatterns.calculator.commands;

import com.ontotext.javacourse.designpatterns.calculator.Calculator;

/** The DivisionCommand class is a command that executes the division operation. */
public class DivisionCommand extends BaseOperation {

  public DivisionCommand(Calculator calculator, double operand) {
    super(calculator, operand);
  }

  @Override
  public void execute() {
    super.getCalculator().divide();
  }
}
