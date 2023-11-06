package com.ontotext.javacourse.threads.producerconsumer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

class TraderRunnableTest {
  private Warehouse warehouse;
  private Thread trader;

  void setUp(int warehouseCapacity, int productsToBuy) {
    warehouse = new Warehouse(warehouseCapacity);
    for (int i = 1; i < warehouseCapacity; i++) {
      warehouse.addProduct("Nobody", i);
    }
    TraderRunnable traderRunnable = new TraderRunnable("John", warehouse, productsToBuy, 100);
    trader = new Thread(traderRunnable);
  }

  @Test
  void traderBuysProductsFromWarehouse() {
    setUp(5, 3);
    trader.start();
    Awaitility.await()
        .atMost(500, TimeUnit.MILLISECONDS)
        .pollInterval(100, TimeUnit.MILLISECONDS)
        .until(() -> warehouse.getProducts().size() == 1);
    assertEquals(1, warehouse.getProducts().size());
  }

  @Test
  void traderBuysProductsFromWarehouseInGivenDelay() {
    setUp(5, 3);
    trader.start();
    Awaitility.await()
        .atMost(200, TimeUnit.MILLISECONDS)
        .pollInterval(50, TimeUnit.MILLISECONDS)
        .until(() -> warehouse.getProducts().size() == 2);
    assertEquals(2, warehouse.getProducts().size());
  }

  @Test
  void traderWaitsForProductToBeAddedIfWarehouseIsEmpty() {
    setUp(3, 4);
    trader.start();
    Awaitility.await()
        .atMost(500, TimeUnit.MILLISECONDS)
        .pollInterval(50, TimeUnit.MILLISECONDS)
        .until(() -> warehouse.getProducts().size() == 0);
    ProducerRunnable producerRunnable =
        new ProducerRunnable("Mr.Producer", warehouse, List.of(10), 200);
    Thread producer = new Thread(producerRunnable);
    producer.start();
    Awaitility.await()
        .atMost(500, TimeUnit.MILLISECONDS)
        .pollInterval(50, TimeUnit.MILLISECONDS)
        .until(() -> warehouse.getProducts().size() == 0);
    assertEquals(0, warehouse.getProducts().size());
  }
}
