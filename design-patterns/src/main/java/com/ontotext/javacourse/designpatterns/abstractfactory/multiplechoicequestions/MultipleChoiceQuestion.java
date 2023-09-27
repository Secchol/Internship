package com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions;

import com.ontotext.javacourse.designpatterns.abstractfactory.Question;

/** Defines a multiple choice question that can check an answer is correct. */
public interface MultipleChoiceQuestion extends Question {
  boolean checkAnswer(String answer);
}
