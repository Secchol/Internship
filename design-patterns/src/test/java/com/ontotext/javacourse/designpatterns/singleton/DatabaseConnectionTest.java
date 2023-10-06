package com.ontotext.javacourse.designpatterns.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.junit.jupiter.api.Test;

class DatabaseConnectionTest {
  @Test
  void getInstanceCreatesOnlyASingleInstanceOfTheClass() {
    DatabaseConnection firstInvocation =
        DatabaseConnection.getInstance("http://localhost:7200/", "myrepo");
    DatabaseConnection secondInvocation =
        DatabaseConnection.getInstance("http://localhost:7200/", "myrepo");
    assertEquals(firstInvocation, secondInvocation);
  }

  @Test
  void getConnectionReturnsRepositoryConnection() {
    assertInstanceOf(
        RepositoryConnection.class,
        DatabaseConnection.getInstance("http://localhost:7200/", "myrepo").getConnection());
  }
}
