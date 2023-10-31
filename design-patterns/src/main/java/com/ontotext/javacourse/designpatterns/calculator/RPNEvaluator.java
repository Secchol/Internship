package com.ontotext.javacourse.designpatterns.calculator;

import java.util.*;

/**
 * The RPNEvaluator class contains methods that return the reverse polish notation of a given
 * expression.
 */
public final class RPNEvaluator {
  private RPNEvaluator() throws IllegalAccessException {
    throw new IllegalAccessException("RPNEvaluator class is not meant to be instantiated!");
  }

  public static List<String> getReversePolishNotation(List<String> expression) {
    return transformExpression(expression);
  }

  /**
   * Determines whether the given item is a valid number.
   *
   * @param item the item which to check the type of
   * @return whether the item is a valid number or not.
   */
  public static boolean isNumeric(String item) {
    try {
      Double.parseDouble(item);
      return true;
    } catch (NumberFormatException exception) {
      return false;
    }
  }

  private static List<String> transformExpression(List<String> expression) {
    if (expression.isEmpty()) {
      throw new IllegalArgumentException("Empty input!");
    }
    Deque<String> stack = new ArrayDeque<>();
    List<String> output = new ArrayList<>();
    for (String item : expression) {
      if (isNumeric(item)) {
        output.add(item);
      } else if (item.equals("(")) {
        stack.push(item);
      } else if (item.equals(")")) {
        while (!stack.isEmpty() && !stack.peek().equals("(")) {
          output.add(stack.pop());
        }
        stack.pop();
      } else {
        while (!stack.isEmpty()
            && getPrecedence(item) <= getPrecedence(stack.peek())
            && hasLeftAssociativity(item)) {
          output.add(stack.pop());
        }
        stack.push(item);
      }
    }
    emptyStack(stack, output);
    return output;
  }

  private static int getPrecedence(String item) {
    return switch (item) {
      case "+", "-" -> 1;
      case "*", "/" -> 2;
      case "^" -> 3;
      default -> -1;
    };
  }

  private static boolean hasLeftAssociativity(String item) {
    return item.equals("+") || item.equals("-") || item.equals("/") || item.equals("*");
  }

  private static void emptyStack(Deque<String> stack, List<String> output) {
    while (!stack.isEmpty()) {
      if (stack.peek().equals("(")) {
        throw new IllegalArgumentException("This expression is invalid");
      }
      output.add(stack.pop());
    }
  }
}
