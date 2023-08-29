package com.ontotext.javacourse.collections.pagebean;

import static com.github.valfirst.slf4jtest.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.valfirst.slf4jtest.TestLogger;
import com.github.valfirst.slf4jtest.TestLoggerFactory;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.event.Level;

class PaginatorViewTest {

  private final TestLogger logger = TestLoggerFactory.getTestLogger(PaginatorView.class);

  private PaginatorView paginatorView = new PaginatorView();

  @AfterEach
  void tearDown() {
    logger.clear();
  }

  @Test
  void displayCommandResultDisplaysGivenMessage() {
    paginatorView.displayCommandResult("result");
    assertThat(logger).hasLogged(Level.INFO, "result");
  }

  @Test
  void getUserCommandInputReturnsUserInput() {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("works\n".getBytes());
    System.setIn(inputStream);
    paginatorView = new PaginatorView();
    assertEquals("works", paginatorView.getUserCommandInput());
  }
}
