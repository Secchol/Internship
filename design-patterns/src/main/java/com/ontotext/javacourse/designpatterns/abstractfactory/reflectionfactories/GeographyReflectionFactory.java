package com.ontotext.javacourse.designpatterns.abstractfactory.reflectionfactories;

import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.GeographyMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.GeographyOpenQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.OpenQuestion;
import java.lang.reflect.InvocationTargetException;

/**
 * The GeographyReflectionFactory class contains method that create a multiple choice geography
 * question and an open answer geography question using reflection.
 */
public class GeographyReflectionFactory implements QuestionReflectionFactory {
  @Override
  public MultipleChoiceQuestion createMultipleChoiceQuestionInstance(String className)
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {
    Object instance = ClassInstantiator.createInstance(className);
    if (!(instance instanceof GeographyMultipleChoiceQuestion)) {
      throw new IllegalArgumentException("Class is not compatible with this factory");
    }
    return (MultipleChoiceQuestion) instance;
  }

  @Override
  public OpenQuestion createOpenQuestionInstance(String className)
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {
    Object instance = ClassInstantiator.createInstance(className);
    if (!(instance instanceof GeographyOpenQuestion)) {
      throw new IllegalArgumentException("Class is not compatible with this factory");
    }
    return (OpenQuestion) instance;
  }
}
