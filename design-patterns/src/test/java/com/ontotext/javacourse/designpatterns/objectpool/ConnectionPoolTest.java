package com.ontotext.javacourse.designpatterns.objectpool;

import static org.junit.jupiter.api.Assertions.*;

import com.ontotext.javacourse.designpatterns.exceptions.NoFreeResourcesException;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ConnectionPoolTest {

  private ConnectionPool connectionPool = new ConnectionPool(10, "http://localhost:7200", "myrepo");

  @AfterEach
  void tearDown() {
    this.connectionPool = new ConnectionPool(10, "http://localhost:7200", "myrepo");
  }

  @Test
  void acquireCreatesNewRepositoryConnection() {
    assertInstanceOf(RepositoryConnection.class, connectionPool.acquire());
  }

  @Test
  void acquireThrowsExceptionIfPoolSizeIsReached() {
    for (int i = 1; i <= 10; i++) {
      connectionPool.acquire();
    }
    assertThrows(NoFreeResourcesException.class, () -> connectionPool.acquire());
  }

  @Test
  void releaseRemovesGivenRepositoryConnection() {
    RepositoryConnection connection = connectionPool.acquire();
    assertTrue(connectionPool.release(connection));
  }

  @Test
  void releaseThrowsExceptionIfConnectionPoolIsEmpty() {
    assertThrows(IllegalStateException.class, () -> connectionPool.release(null));
  }
}
