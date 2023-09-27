package com.ontotext.javacourse.designpatterns.abstractfactory.factorymethodfactories;

import static org.junit.jupiter.api.Assertions.*;

import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.GeographyMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.HistoryMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MathsMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.GeographyOpenQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.HistoryOpenQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.MathsOpenQuestion;
import org.junit.jupiter.api.Test;

class QuestionFactoryTest {
  @Test
  void geographyFactoryCreatesMultipleChoiceQuestionCorrectly() {
    QuestionFactory factory = new GeographyFactory();
    assertInstanceOf(GeographyMultipleChoiceQuestion.class, factory.createMultipleChoiceQuestion());
  }

  @Test
  void geographyFactoryCreatesOpenAnswerQuestionCorrectly() {
    QuestionFactory factory = new GeographyFactory();
    assertInstanceOf(GeographyOpenQuestion.class, factory.createOpenQuestion());
  }

  @Test
  void historyFactoryCreatesMultipleChoiceQuestionCorrectly() {
    QuestionFactory factory = new HistoryFactory();
    assertInstanceOf(HistoryMultipleChoiceQuestion.class, factory.createMultipleChoiceQuestion());
  }

  @Test
  void historyFactoryCreatesOpenAnswerQuestionCorrectly() {
    QuestionFactory factory = new HistoryFactory();
    assertInstanceOf(HistoryOpenQuestion.class, factory.createOpenQuestion());
  }

  @Test
  void mathsFactoryCreatesMultipleChoiceQuestionCorrectly() {
    QuestionFactory factory = new MathsFactory();
    assertInstanceOf(MathsMultipleChoiceQuestion.class, factory.createMultipleChoiceQuestion());
  }

  @Test
  void mathsFactoryCreatesOpenAnswerQuestionCorrectly() {
    QuestionFactory factory = new MathsFactory();
    assertInstanceOf(MathsOpenQuestion.class, factory.createOpenQuestion());
  }
}
