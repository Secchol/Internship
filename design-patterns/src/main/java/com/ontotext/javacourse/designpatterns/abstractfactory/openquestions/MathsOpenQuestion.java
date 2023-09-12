package com.ontotext.javacourse.designpatterns.abstractfactory.openquestions;

/** This class defines an open maths question. */
public class MathsOpenQuestion implements OpenQuestion {
  @Override
  public void writeAnswer(String answer) {
    System.out.println(answer);
  }
}
