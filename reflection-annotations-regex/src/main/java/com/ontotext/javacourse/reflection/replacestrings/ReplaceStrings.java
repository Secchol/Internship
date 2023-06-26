package com.ontotext.javacourse.reflection.replacestrings;

import java.util.regex.Pattern;

/**
 * The ReplaceStrings class contains a method which for a given string replaces the given content
 * surrounded by "<x>" and "</x>" with "<x/>".
 */
public final class ReplaceStrings {
  private static final Pattern PATTERN = Pattern.compile("<x>[^(</x>)]*</x>");

  private ReplaceStrings() throws IllegalAccessException {
    throw new IllegalAccessException("ReplaceStrings class is not meant to be instantiated");
  }

  /**
   * Replaces the given content surrounded by "<x>" and "</x>" with "<x/>".
   *
   * @param input the input to replace the string in
   * @return the replaced string
   */
  public static String replaceStrings(String input) {
    return PATTERN.matcher(input).replaceAll("<x/>");
  }
}
