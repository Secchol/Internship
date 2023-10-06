package com.ontotext.javacourse.designpatterns.singleton;

import com.ontotext.graphdb.repository.http.GraphDBHTTPRepository;
import com.ontotext.graphdb.repository.http.GraphDBHTTPRepositoryBuilder;
import org.eclipse.rdf4j.repository.RepositoryConnection;

/** Defines a class that provides a connection to a GraphDB database repository. */
public class DatabaseConnection {
  private static DatabaseConnection instance;
  private static RepositoryConnection connection;

  private DatabaseConnection() {}

  /**
   * Creates the connection if it has not been created yet and returns it.
   *
   * @return the repository connection
   */
  public static DatabaseConnection getInstance(String url, String repoId) {
    if (instance == null) {
      instance = new DatabaseConnection();
      GraphDBHTTPRepository repository =
          new GraphDBHTTPRepositoryBuilder().withServerUrl(url).withRepositoryId(repoId).build();
      connection = repository.getConnection();
    }
    return instance;
  }

  public RepositoryConnection getConnection() {
    return connection;
  }
}
