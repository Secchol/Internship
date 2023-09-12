package com.ontotext.javacourse.designpatterns.abstractfactory.openquestions;

/** This class defines an open geography question. */
public class GeographyOpenQuestion implements OpenQuestion {
  @Override
  public void writeAnswer(String answer) {
    System.out.println(answer);
  }
}
