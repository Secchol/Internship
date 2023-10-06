package com.ontotext.javacourse.designpatterns.calculator;

import com.ontotext.javacourse.designpatterns.calculator.commands.Command;
import lombok.Setter;

/** Accepts a command and contains a method that can execute it. */
@Setter
public class CalculatorInvoker {
  private Command command;

  public void executeCommand() {
    command.execute();
  }
}
