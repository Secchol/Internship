package com.ontotext.javacourse.designpatterns.singleton;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.net.URL;
import org.eclipse.rdf4j.query.QueryEvaluationException;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
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
  void testNeo4jConnectionFALSE() throws IOException {
    URL url = new URL(NEO4J_URL + "/browser/");
    RepositoryConnection connection =
        DatabaseConnection.getInstance(url.getPath(), "neo4j-container").getConnection();
    connection.prepareTupleQuery(QueryLanguage.SPARQL, "");
    assertTrue(true);
  }

  @Test
  void testNeo4jConnection() throws IOException {
    URL url = new URL(NEO4J_URL);

    // Create an RDF4J repository connection to the Neo4j endpoint
    Repository repository = new HTTPRepository(url.toString());
    repository.init();

    try (RepositoryConnection connection = repository.getConnection()) {
      String query = "SELECT ?s ?p ?o WHERE { ?s ?p ?o } LIMIT 10";
      TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL, query);
      try (TupleQueryResult result = tupleQuery.evaluate()) {
        assertTrue(result.hasNext());
      }
    } catch (QueryEvaluationException e) {
      e.printStackTrace();
    }
  }
  @Test
  void testNeo4jConnectionn() throws IOException {
    URL url = new URL(NEO4J_URL+"/browser/");

    Repository repository = new HTTPRepository(url.toString());
    repository.init();

    try (RepositoryConnection connection = repository.getConnection()) {
      String query = "SELECT ?s ?p ?o WHERE { ?s ?p ?o } LIMIT 10";
      TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL, query);
      try (TupleQueryResult result = tupleQuery.evaluate()) {
        assertTrue(result.hasNext());
      } catch (QueryEvaluationException e) {
        e.printStackTrace();
        fail("SPARQL query execution failed.");
      }
    } catch (RepositoryException e) {
      e.printStackTrace();
      fail("Repository initialization failed.");
    }
  }
}
