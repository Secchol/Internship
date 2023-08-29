package com.ontotext.javacourse.collections.pagebean;

import static com.github.valfirst.slf4jtest.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.github.valfirst.slf4jtest.TestLogger;
import com.github.valfirst.slf4jtest.TestLoggerFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.event.Level;

class PaginatorControllerTest {

  private final TestLogger logger = TestLoggerFactory.getTestLogger(PaginatorView.class);

  private final PaginatorController<String> paginatorController =
      new PaginatorController<>(createPaginatorModel(), new PaginatorView());

  @Test
  void startCallsNextCommandOnMethodCall() {
    paginatorController.start();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("works\n".getBytes());
    System.setIn(inputStream);
    assertThat(logger).hasLogged(Level.INFO, "sdfsd");
  }

  private PaginatorModel<String> createPaginatorModel() {
    List<String> testData = new ArrayList<>();
    for (int i = 1; i <= 16; i++) {
      testData.add("Item " + i);
    }
    return new PaginatorModel<>(testData, 5);
  }
}
