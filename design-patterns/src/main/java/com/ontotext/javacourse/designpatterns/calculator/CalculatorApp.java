package com.ontotext.javacourse.designpatterns.calculator;

import com.ontotext.javacourse.designpatterns.calculator.commands.*;
import java.security.InvalidParameterException;

/**
 * The CalculatorApp class contains a method that starts the calculator and begins to accept
 * operation and executes them.
 */
public class CalculatorApp {
  private final CalculatorView calculatorView;
  private final Calculator calculator;
  private final CalculatorInvoker calculatorInvoker;

  public CalculatorApp(Calculator calculator) {
    calculatorView = new CalculatorView();
    this.calculator = calculator;
    calculatorInvoker = new CalculatorInvoker();
  }

  /** Starts accepting user input from the console. */
  public void startCalculator() {
    calculatorView.displayAvailableCommands();
    double startingNumber = calculatorView.promptNumberInput();
    calculatorInvoker.setCommand(new AddCommand(this.calculator, startingNumber));
    calculatorInvoker.executeCommand();
    int operationNumber = calculatorView.promptOperationNumber();
    double operand = 0;
    while (operationNumber != 6) {
      operand = calculatorView.promptNumberInput();
      Command command = getOperationCommand(operationNumber, operand);
      calculatorInvoker.setCommand(command);
      calculatorInvoker.executeCommand();
      calculatorView.displayCurrentResult(calculator.getResult());
      operationNumber = calculatorView.promptOperationNumber();
    }
    calculatorView.displayEndResult(calculator.getResult());
  }

  private Command getOperationCommand(int operationNumber, double operand) {
    return switch (operationNumber) {
      case 1 -> new AddCommand(this.calculator, operand);
      case 2 -> new SubtractCommand(this.calculator, operand);
      case 3 -> new MultiplyCommand(this.calculator, operand);
      case 4 -> new DivisionCommand(this.calculator, operand);
      case 5 -> new ExponentiateCommand(this.calculator, operand);
      default -> throw new InvalidParameterException("Invalid operand number!");
    };
  }
}
