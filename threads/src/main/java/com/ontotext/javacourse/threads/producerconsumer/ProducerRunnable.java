package com.ontotext.javacourse.threads.producerconsumer;

import java.util.Collection;
import lombok.AllArgsConstructor;

/**
 * The ProducerRunnable class defines a producer that has a name and produces given products and
 * adds them to a warehouse at a given time interval.
 */
@AllArgsConstructor
public class ProducerRunnable implements Runnable {
  private final String name;
  private final Warehouse warehouse;

  private final Collection<Object> productsToProduce;

  private final long productionDelay;

  @Override
  public void run() {
    for (Object product : productsToProduce) {
      warehouse.addProduct(name, product);
      try {
        Thread.sleep(productionDelay);
      } catch (InterruptedException exception) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
