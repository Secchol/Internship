package com.ontotext.javacourse.designpatterns.abstractfactory.openquestions;

/**
 * This class defines an open history question.
 */
public class HistoryOpenQuestion implements OpenQuestion {
  @Override
  public void writeAnswer(String answer) {
    System.out.println(answer);
  }
}
