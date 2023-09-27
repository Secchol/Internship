package com.ontotext.javacourse.designpatterns.objectpool;

import com.ontotext.graphdb.repository.http.GraphDBHTTPRepository;
import com.ontotext.graphdb.repository.http.GraphDBHTTPRepositoryBuilder;
import com.ontotext.javacourse.designpatterns.exceptions.NoFreeResourcesException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.rdf4j.repository.RepositoryConnection;

/**
 * The ConnectionPool class is a database connection pool that creates a max number of connections
 * to a given repository.
 */
public class ConnectionPool {
  private final List<RepositoryConnection> connections;
  private final GraphDBHTTPRepository repository;
  private final int poolSize;

  public ConnectionPool(int poolSize, String url, String repositoryId) {
    this.poolSize = poolSize;
    this.repository =
        new GraphDBHTTPRepositoryBuilder()
            .withServerUrl(url)
            .withRepositoryId(repositoryId)
            .build();
    this.connections = new ArrayList<>(poolSize);
  }

  /**
   * Creates a new repository connection and adds it to the connection pool if the max pool size is
   * not reached.
   *
   * @return the created repository connection
   */
  public RepositoryConnection acquire() {
    if (connections.size() >= this.poolSize) {
      throw new NoFreeResourcesException("Object pool has no free resources!");
    }
    RepositoryConnection connection = repository.getConnection();
    connections.add(connection);
    return connection;
  }

  /**
   * Closes and removes a given repository connection if it is present in the connection pool.
   *
   * @param repositoryConnection the repository connection to remove
   */
  public boolean release(RepositoryConnection repositoryConnection) {
    if (connections.isEmpty()) {
      throw new IllegalStateException("There are no resources to release!");
    }
    repositoryConnection.close();
    return connections.remove(repositoryConnection);
  }
}
