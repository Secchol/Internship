package com.ontotext.javacourse.designpatterns.calculator.commands;

import com.ontotext.javacourse.designpatterns.calculator.Calculator;
import lombok.Getter;

/**
 * The BaseOperation class defines a command that takes a calculator instance and an operand upon
 * instantiation.
 */
@Getter
public abstract class BaseOperation implements Command {
  private final Calculator calculator;

  public BaseOperation(Calculator calculator, double operand) {
    this.calculator = calculator;
    this.calculator.setOperand(operand);
  }
}
