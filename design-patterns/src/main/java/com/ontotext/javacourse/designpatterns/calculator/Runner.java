package com.ontotext.javacourse.designpatterns.calculator;

public class Runner {
  public static void main(String[] args) {
    CalculatorApp app = new CalculatorApp(new Calculator());
    app.startCalculator();
  }
}
