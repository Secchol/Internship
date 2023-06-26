package com.ontotext.javacourse.reflection.validateemail;

import java.util.regex.Pattern;

/** The ValidateEmail class contains a method which validates a string as an email address. */
public final class ValidateEmail {
  private static final Pattern PATTERN =
      Pattern.compile("^[A-Za-z][A-Za-z0-9.-]*@[A-Za-z][A-Za-z0-9.-]*$");

  private ValidateEmail() throws IllegalAccessException {
    throw new IllegalAccessException("ValidateEmail class is not meant to be instantiated");
  }

  /**
   * Validates if a given string is a valid email and returns bool.
   *
   * @param input the string to validate.
   * @return a bool indicating whether the input is a valid email.
   */
  public static boolean validateEmail(String input) {
    return PATTERN.matcher(input).matches();
  }
}
