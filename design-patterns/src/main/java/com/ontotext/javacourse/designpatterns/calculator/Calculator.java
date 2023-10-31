package com.ontotext.javacourse.designpatterns.calculator;

import com.ontotext.javacourse.designpatterns.calculator.commands.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * The Calculator class contains a method that takes a given reverse polish notation expression and
 * returns its result.
 */
public final class Calculator {

  private Calculator() throws IllegalAccessException {
    throw new IllegalAccessException("Calculator class is not meant to be instantiated!");
  }

  /**
   * Evaluates the given expression.
   *
   * @param reversePolishNotationExpression the reverse polish notation expression
   * @return the result of the expression
   */
  public static double evaluateExpression(List<String> reversePolishNotationExpression) {
    Deque<Double> stack = new ArrayDeque<>();
    double firstOperand;
    double secondOperand;
    Double result;
    for (String item : reversePolishNotationExpression) {
      if (RPNEvaluator.isNumeric(item)) {
        stack.push(Double.parseDouble(item));
      } else {
        secondOperand = stack.pop();
        firstOperand = stack.pop();
        Command command = getCommand(item);
        result = command.execute(firstOperand, secondOperand);
        stack.push(result);
      }
    }
    return stack.pop();
  }

  private static Command getCommand(String action) {
    return switch (action) {
      case "+" -> new AddCommand();
      case "-" -> new SubtractCommand();
      case "*" -> new MultiplyCommand();
      case "/" -> new DivisionCommand();
      case "^" -> new ExponentiateCommand();
      default -> throw new IllegalArgumentException("Action is invalid!");
    };
  }
}
