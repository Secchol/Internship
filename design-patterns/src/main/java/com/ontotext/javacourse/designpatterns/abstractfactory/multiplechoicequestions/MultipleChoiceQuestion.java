package com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions;

/** Defines a multiple choice question that can check an answer is correct. */
public interface MultipleChoiceQuestion {
  void askQuestion();

  boolean checkAnswer(String answer);
}
