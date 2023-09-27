package com.ontotext.javacourse.designpatterns.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.junit.jupiter.api.Test;

class DatabaseConnectionTest {
  @Test
  void getInstanceCreatesOnlyASingleInstanceOfTheClass() {
    DatabaseConnection firstInvocation = DatabaseConnection.getInstance();
    DatabaseConnection secondInvocation = DatabaseConnection.getInstance();
    assertEquals(firstInvocation, secondInvocation);
  }

  @Test
  void getConnectionReturnsRepositoryConnection() {
    assertInstanceOf(RepositoryConnection.class, DatabaseConnection.getInstance().getConnection());
  }
}
