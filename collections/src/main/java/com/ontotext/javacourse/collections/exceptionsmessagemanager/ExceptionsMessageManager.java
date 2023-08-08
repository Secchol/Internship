package com.ontotext.javacourse.collections.exceptionsmessagemanager;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * The ExceptionsMessageManager class contains methods that generate a single string message from a
 * combination of a predefined map of string messages containing exception key and exception
 * message.
 */
@Getter
@Setter
public class ExceptionsMessageManager {
  private static String delimiter;
  private final ArrayList<String> elementsToConcatenate;
  private Map<String, String> map;

  public ExceptionsMessageManager(Map<String, String> map, String delimiter) {
    elementsToConcatenate = new ArrayList<>();
    ExceptionsMessageManager.delimiter = delimiter;
    setMap(map);
  }

  /**
   * Splits the messagesCombination parameter on its composite strings and returns them as a
   * collection of strings.
   *
   * @param messagesCombination the message combination to split
   * @return the collection of strings
   */
  public static Collection<String> getMessages(String messagesCombination) {
    if (messagesCombination.isEmpty()) {
      return new ArrayList<>();
    }
    return Arrays.stream(messagesCombination.split(Pattern.quote(delimiter))).toList();
  }

  /**
   * Checks if there is a message with such value in the predefined exception Map and concatenates
   * it to the generated string.
   *
   * @param message the value of the message to add
   */
  public void addExceptionMessage(String message) {
    if (map.containsValue(message)) {
      elementsToConcatenate.add(message);
    } else {
      throw new InvalidParameterException("The value is not present in the map!");
    }
  }

  /**
   * Checks if there is a message with such a key in the predefined exception Map and concatenates
   * it to the generated string.
   *
   * @param messageCode the key of the message to add
   */
  public void addExceptionMessageUsingCode(String messageCode) {
    if (map.containsKey(messageCode)) {
      elementsToConcatenate.add(messageCode);
    } else {
      throw new InvalidParameterException("The key is not present in the map!");
    }
  }

  /**
   * Constructs the string.
   *
   * @return the value of the generated string
   */
  public String getMessage() {
    return String.join(delimiter, elementsToConcatenate);
  }
}
