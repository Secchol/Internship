package com.ontotext.javacourse.designpatterns.abstractfactory;

import com.ontotext.javacourse.designpatterns.abstractfactory.factorymethodfactories.GeographyFactory;
import com.ontotext.javacourse.designpatterns.abstractfactory.factorymethodfactories.HistoryFactory;
import com.ontotext.javacourse.designpatterns.abstractfactory.factorymethodfactories.MathsFactory;
import com.ontotext.javacourse.designpatterns.abstractfactory.factorymethodfactories.QuestionFactory;
import java.security.InvalidParameterException;
import java.util.Random;

/**
 * This is a trivia game. Each game you start has rounds and every round the player gets a multiple
 * choice question and an open answer question on a randomly selected topic - History, Maths or
 * Geography.
 */
public class Game {
  private static final String[] questionTopics = new String[] {"History", "Maths", "Geography"};

  /** Selects a random topic and starts the round. */
  public void startRound() {
    String topic = pickRandomTopic();
    QuestionFactory factory =
        switch (topic) {
          case "History" -> new HistoryFactory();
          case "Maths" -> new MathsFactory();
          case "Geography" -> new GeographyFactory();
          default -> throw new InvalidParameterException("Invalid topic!");
        };
    Round round = new Round(factory);
    round.start();
  }

  private String pickRandomTopic() {
    Random random = new Random();
    int randomNumber = random.nextInt(0, 3);
    return questionTopics[randomNumber];
  }
}
