package com.ontotext.javacourse.designpatterns.abstractfactory.openquestions;

/** Defines an open question that can accept an answer. */
public interface OpenQuestion {
  void writeAnswer(String answer);
}
