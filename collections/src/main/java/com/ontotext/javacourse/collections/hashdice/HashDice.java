package com.ontotext.javacourse.collections.hashdice;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The HashDice class contains methods that take two dice with M sides that are rolled N times
 * simultaneously and create statistics for the results.
 */
public class HashDice {
  private static final Random randomNumber = new Random();
  private static final Logger LOGGER = LoggerFactory.getLogger(HashDice.class);
  private final Scanner scanner;

  public HashDice(InputStream inputStream) {
    scanner = new Scanner(inputStream);
  }

  /**
   * Displays statistics about two dice with M sides that are rolled N times.
   *
   * @return a map containing the results after the dice are rolled
   */
  public Map<String, HashSet<Integer>> buildStatistics() {
    Map<String, HashSet<Integer>> results = new HashMap<>();
    int sides = getSides();
    int rolls = getRolls();
    if (sides <= 0) {
      throw new IllegalArgumentException("Dice sides must be larger than zero!");
    }
    for (int currentRoll = 1; currentRoll <= rolls; currentRoll++) {
      String combination = rollDice(sides);
      results.computeIfAbsent(combination, k -> new HashSet<>());
      results.get(combination).add(currentRoll);
    }
    displayStatistics(results);
    return results;
  }

  private int getSides() {
    LOGGER.info("Enter dice sides:");
    return scanner.nextInt();
  }

  private int getRolls() {
    LOGGER.info("Enter number of rolls:");
    return scanner.nextInt();
  }

  private String rollDice(int sides) {
    int firstDiceResult = randomNumber.nextInt(1, sides + 1);
    int secondDiceResult = randomNumber.nextInt(1, sides + 1);
    return firstDiceResult + "," + secondDiceResult;
  }

  private void displayStatistics(Map<String, HashSet<Integer>> results) {
    results.forEach(
        (key, value) ->
            LOGGER.info(
                "Dice combination: {} - At throw number: {}",
                key,
                value.stream().map(Object::toString).collect(Collectors.joining(", "))));
  }
}
