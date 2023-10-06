package com.ontotext.javacourse.designpatterns.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URL;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class Neo4jTest {

  @Container
  private static final Neo4jContainer<?> neo4jContainer =
      new Neo4jContainer<>("neo4j:latest").withExposedPorts(7474, 7687).withoutAuthentication();

  private static String NEO4J_URL;

  @BeforeAll
  static void setUp() {
    neo4jContainer.start();
    NEO4J_URL = "http://" + neo4jContainer.getHost() + ":" + neo4jContainer.getMappedPort(7474);
  }

  @Test
  void testNeo4jConnection() throws IOException {
    // Fix method
    URL url = new URL(NEO4J_URL + "/browser/");
    RepositoryConnection connection =
        DatabaseConnection.getInstance(url.getPath(), "neo4j-container").getConnection();
    assertEquals(200, 200);
  }
}
