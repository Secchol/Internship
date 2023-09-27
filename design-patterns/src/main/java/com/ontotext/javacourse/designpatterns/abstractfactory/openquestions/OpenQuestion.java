package com.ontotext.javacourse.designpatterns.abstractfactory.openquestions;

import com.ontotext.javacourse.designpatterns.abstractfactory.Question;

/** Defines an open question that can accept an answer. */
public interface OpenQuestion extends Question {
  void writeAnswer(String answer);
}
