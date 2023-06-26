package com.ontotext.javacourse.reflection.ibanvalidator;

import java.util.regex.Pattern;

/**
 * The IBANValidator class contains a method which takes a string and replaces all valid IBAN
 * numbers with '****'.
 */
public final class IBANValidator {

  private static final Pattern PATTERN =
      Pattern.compile("BG\\d{2}\\s*[A-Z]{4}\\s*(\\d{4}\\s*){3}\\d{2}");

  private IBANValidator() throws IllegalAccessException {
    throw new IllegalAccessException("IBANValidator class is not meant to be instantiated");
  }

  /**
   * Takes a string and replaces all valid IBAN numbers with '****'.
   *
   * @param iban the string to search iban in
   * @return the string with replaced valid iban numbers
   */
  public static String validateIBAN(String iban) {
    return PATTERN.matcher(iban).replaceAll("****");
  }
}
