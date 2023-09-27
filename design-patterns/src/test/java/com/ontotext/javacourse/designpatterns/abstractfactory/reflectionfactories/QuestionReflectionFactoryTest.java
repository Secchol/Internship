package com.ontotext.javacourse.designpatterns.abstractfactory.reflectionfactories;

import static org.junit.jupiter.api.Assertions.*;

import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.GeographyMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.HistoryMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MathsMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.GeographyOpenQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.HistoryOpenQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.MathsOpenQuestion;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class QuestionReflectionFactoryTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(QuestionReflectionFactoryTest.class);

  @Test
  void geographyReflectionFactoryCreatesMultipleChoiceQuestionCorrectly()
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {

    QuestionReflectionFactory factory = new GeographyReflectionFactory();
    assertInstanceOf(
        GeographyMultipleChoiceQuestion.class,
        factory.createMultipleChoiceQuestionInstance(
            "com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.GeographyMultipleChoiceQuestion"));
  }

  @Test
  void geographyReflectionFactoryCreatesOpenAnswerQuestionCorrectly()
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {
    QuestionReflectionFactory factory = new GeographyReflectionFactory();
    assertInstanceOf(
        GeographyOpenQuestion.class,
        factory.createOpenQuestionInstance(
            "com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.GeographyOpenQuestion"));
  }

  @Test
  void historyReflectionFactoryCreatesMultipleChoiceQuestionCorrectly()
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {
    QuestionReflectionFactory factory = new HistoryReflectionFactory();
    assertInstanceOf(
        HistoryMultipleChoiceQuestion.class,
        factory.createMultipleChoiceQuestionInstance(
            "com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.HistoryMultipleChoiceQuestion"));
  }

  @Test
  void historyReflectionFactoryCreatesOpenAnswerQuestionCorrectly()
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {
    QuestionReflectionFactory factory = new HistoryReflectionFactory();
    assertInstanceOf(
        HistoryOpenQuestion.class,
        factory.createOpenQuestionInstance(
            "com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.HistoryOpenQuestion"));
  }

  @Test
  void mathsReflectionFactoryCreatesMultipleChoiceQuestionCorrectly()
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {
    QuestionReflectionFactory factory = new MathsReflectionFactory();
    assertInstanceOf(
        MathsMultipleChoiceQuestion.class,
        factory.createMultipleChoiceQuestionInstance(
            "com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MathsMultipleChoiceQuestion"));
  }

  @Test
  void mathsReflectionFactoryCreatesOpenAnswerQuestionCorrectly()
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {
    QuestionReflectionFactory factory = new MathsReflectionFactory();
    assertInstanceOf(
        MathsOpenQuestion.class,
        factory.createOpenQuestionInstance(
            "com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.MathsOpenQuestion"));
  }
}
