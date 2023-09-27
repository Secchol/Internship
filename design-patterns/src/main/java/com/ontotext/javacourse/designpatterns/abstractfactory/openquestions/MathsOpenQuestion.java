package com.ontotext.javacourse.designpatterns.abstractfactory.openquestions;

/** This class defines an open maths question. */
public class MathsOpenQuestion implements OpenQuestion {
  @Override
  public void writeAnswer(String answer) {
    System.out.println(answer);
  }

  @Override
  public void askQuestion() {
    System.out.println("What are the roots of this quadratic equation?");
    System.out.println("x²+3x-4 =0");
  }
}
