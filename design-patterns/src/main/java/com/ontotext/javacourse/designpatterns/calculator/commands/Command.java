package com.ontotext.javacourse.designpatterns.calculator.commands;

/** Defines a command that can be executed. */
public interface Command {
  Double execute(Double firstOperand, Double secondOperand);
}
