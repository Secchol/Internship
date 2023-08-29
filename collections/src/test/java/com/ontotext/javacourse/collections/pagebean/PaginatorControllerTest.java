package com.ontotext.javacourse.collections.pagebean;

import static com.github.valfirst.slf4jtest.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.github.valfirst.slf4jtest.TestLogger;
import com.github.valfirst.slf4jtest.TestLoggerFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.event.Level;

class PaginatorControllerTest {

  private final TestLogger logger = TestLoggerFactory.getTestLogger(PaginatorView.class);

  private PaginatorController<String> paginatorController;

  @AfterEach
  void tearDown() {
    logger.clear();
  }

  @Test
  void startCallsNextCommandOnMethodCall() {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("end\n".getBytes());
    System.setIn(inputStream);
    PaginatorController<String> controller = createPaginatorController();
    controller.start();
    assertThat(logger).hasLogged(Level.INFO, "[Item 1, Item 2, Item 3, Item 4, Item 5]");
  }

  @Test
  void startExecutesCommandCorrectlyAndReturnsResult() {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("next()\nend\n".getBytes());
    System.setIn(inputStream);
    PaginatorController<String> controller = createPaginatorController();
    controller.start();
    assertThat(logger).hasLogged(Level.INFO, "[Item 6, Item 7, Item 8, Item 9, Item 10]");
  }

  @Test
  void startReturnsCorrectMessageWhenIncorrectCommandIsGiven() {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("previous()\nend\n".getBytes());
    System.setIn(inputStream);
    PaginatorController<String> controller = createPaginatorController();
    controller.start();
    assertThat(logger).hasLogged(Level.INFO, "Invalid operation!");
  }

  private PaginatorController<String> createPaginatorController() {
    List<String> testData = new ArrayList<>();
    for (int i = 1; i <= 16; i++) {
      testData.add("Item " + i);
    }
    return new PaginatorController<>(new PaginatorModel<>(testData, 5), new PaginatorView());
  }
}
