package com.ontotext.javacourse.designpatterns.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The CalculatorApp class contains a method that starts the calculator and accepts an expression as
 * input.
 */
public class CalculatorApp {
  private final Scanner scanner;

  public CalculatorApp() {
    scanner = new Scanner(System.in);
  }

  /** Starts accepting user input from the console. */
  public void startCalculator() {
    System.out.println("Enter an expression with a space between each number and symbol:");
    String input = scanner.nextLine();
    List<String> expression = Arrays.stream(input.split(" ")).toList();
    List<String> reversePolishNotationExpression =
        RPNEvaluator.getReversePolishNotation(expression);
    double result = Calculator.evaluateExpression(reversePolishNotationExpression);
    System.out.printf("Result: %.2f%n", result);
  }
}
