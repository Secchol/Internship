package com.ontotext.javacourse.threads.producerconsumer;

import lombok.AllArgsConstructor;

/**
 * The TraderRunnable class defines a trader that has a name and buys a certain amount of products from a
 * warehouse at a given time interval.
 */
@AllArgsConstructor
public class TraderRunnable implements Runnable {
  private final String name;
  private final Warehouse warehouse;
  private final int productsToBuy;
  private final long buyDelay;

  @Override
  public void run() {
    for (int i = 0; i < productsToBuy; i++) {
      warehouse.buyProduct(name);
      try {
        Thread.sleep(buyDelay);
      } catch (InterruptedException exception) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
