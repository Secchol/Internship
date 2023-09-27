package com.ontotext.javacourse.designpatterns.singleton;

import com.ontotext.graphdb.repository.http.GraphDBHTTPRepository;
import com.ontotext.graphdb.repository.http.GraphDBHTTPRepositoryBuilder;
import org.eclipse.rdf4j.repository.RepositoryConnection;

/** Defines a class that provides a connection to a GraphDB database repository. */
public class DatabaseConnection {
  private static DatabaseConnection instance;
  private final RepositoryConnection connection;

  private DatabaseConnection() {
    GraphDBHTTPRepository repository =
        new GraphDBHTTPRepositoryBuilder()
            .withServerUrl("http://localhost:7200")
            .withRepositoryId("myrepo")
            .build();
    this.connection = repository.getConnection();
  }

  /**
   * Creates the connection if it has not been created yet and returns it.
   *
   * @return the repository connection
   */
  public static DatabaseConnection getInstance() {
    if (instance == null) {
      instance = new DatabaseConnection();
    }
    return instance;
  }

  public RepositoryConnection getConnection() {
    return connection;
  }
}
