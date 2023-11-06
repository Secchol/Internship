package com.ontotext.javacourse.threads.producerconsumer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

class ProducerRunnableTest {

  private static final List<Object> PRODUCTS = List.of("a", "b", "c");
  private Warehouse warehouse;
  private Thread producer;

  void setUp(int warehouseCapacity) {
    warehouse = new Warehouse(warehouseCapacity);
    ProducerRunnable producerRunnable = new ProducerRunnable("Ivan", warehouse, PRODUCTS, 100);
    producer = new Thread(producerRunnable);
  }

  @Test
  void producerAddsProductsToWarehouse() {
    setUp(10);
    producer.start();
    Awaitility.await()
        .atMost(5, TimeUnit.SECONDS)
        .pollInterval(100, TimeUnit.MILLISECONDS)
        .until(() -> warehouse.getProducts().size() == 3);
    assertEquals(3, warehouse.getProducts().size());
  }

  @Test
  void producerAddsProductsToWarehouseInGivenDelay() {
    setUp(10);
    producer.start();
    Awaitility.await()
        .atMost(150, TimeUnit.MILLISECONDS)
        .pollInterval(50, TimeUnit.MILLISECONDS)
        .until(() -> warehouse.getProducts().size() == 2);
    assertEquals(2, warehouse.getProducts().size());
  }

  @Test
  void producerWaitsForFreeSpaceIfWarehouseIsFull() {
    setUp(2);
    TraderRunnable traderRunnable = new TraderRunnable("John", warehouse, 1, 100);
    Thread trader = new Thread(traderRunnable);
    producer.start();
    Awaitility.await()
        .atMost(200, TimeUnit.MILLISECONDS)
        .pollInterval(10, TimeUnit.MILLISECONDS)
        .until(() -> warehouse.getProducts().size() == 2);
    trader.start();
    Awaitility.await()
        .atMost(200, TimeUnit.MILLISECONDS)
        .pollInterval(10, TimeUnit.MILLISECONDS)
        .until(() -> warehouse.getProducts().size() == 2);
    assertEquals(2, warehouse.getProducts().size());
  }
}
