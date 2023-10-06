package com.ontotext.javacourse.designpatterns.calculator;

import java.util.Scanner;

/**
 * The CalculatorView class contains methods that display text and take user input from the console.
 */
public class CalculatorView {
  private final Scanner scanner = new Scanner(System.in);

  public void displayAvailableCommands() {
    System.out.println("Available operations:");
    System.out.println("Addition - 1");
    System.out.println("Subtraction - 2");
    System.out.println("Multiplication - 3");
    System.out.println("Division - 4");
    System.out.println("Exponentiation - 5");
    System.out.println("Exit - 6");
  }

  public double promptNumberInput() {
    System.out.println("Enter operand:");
    return scanner.nextDouble();
  }

  public int promptOperationNumber() {
    System.out.println("Enter operation number:");
    return scanner.nextInt();
  }

  public void displayCurrentResult(double result) {
    System.out.printf("Current result is: %f%n", result);
  }

  public void displayEndResult(double result) {
    System.out.println("Calculator is over!");
    System.out.printf("End result is %f%n", result);
  }
}
