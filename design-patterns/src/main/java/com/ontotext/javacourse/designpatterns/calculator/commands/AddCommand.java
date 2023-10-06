package com.ontotext.javacourse.designpatterns.calculator.commands;

import com.ontotext.javacourse.designpatterns.calculator.Calculator;

/** The AddCommand class is a command that executes the addition operation. */
public class AddCommand extends BaseOperation {

  public AddCommand(Calculator calculator, double operand) {
    super(calculator, operand);
  }

  @Override
  public void execute() {
    super.getCalculator().add();
  }
}
