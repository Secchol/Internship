package com.ontotext.javacourse.designpatterns.abstractfactory;

import com.ontotext.javacourse.designpatterns.abstractfactory.factories.GeographyFactory;
import com.ontotext.javacourse.designpatterns.abstractfactory.factories.HistoryFactory;
import com.ontotext.javacourse.designpatterns.abstractfactory.factories.MathsFactory;
import com.ontotext.javacourse.designpatterns.abstractfactory.factories.QuestionFactory;
import java.security.InvalidParameterException;
import java.util.Random;

/**
 * This is a trivia game. Each game you start has rounds and every round the player gets a multiple
 * choice question and an open answer question on a randomly selected topic - History, Maths or
 * Geography.
 */
public class Game {
  private static final Random random = new Random();
  private static final String[] questionTopics = new String[] {"History", "Maths", "Geography"};

  /** Selects a random topic and starts the round. */
  public void startRound() {
    String topic = pickRandomTopic();
    QuestionFactory factory;
    if (topic.equals("History")) {
      factory = new HistoryFactory();
    } else if (topic.equals("Maths")) {
      factory = new MathsFactory();
    } else if (topic.equals("Geography")) {
      factory = new GeographyFactory();
    } else {
      throw new InvalidParameterException("Unknown topic!");
    }
    Round round = new Round(factory);
    round.start();
  }

  private String pickRandomTopic() {
    int randomNumber = random.nextInt(3);
    return questionTopics[randomNumber];
  }
}
