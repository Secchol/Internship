package com.ontotext.javacourse.threads.producerconsumer;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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
    try {
      sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(3, warehouse.getProducts().size());
  }

  @Test
  void producerAddsProductsToWarehouseInGivenDelay() {
    setUp(10);
    producer.start();
    try {
      sleep(150);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(2, warehouse.getProducts().size());
  }

  @Test
  void producerWaitsForFreeSpaceIfWarehouseIsFull() {
    setUp(2);
    TraderRunnable traderRunnable = new TraderRunnable("John", warehouse, 1, 100);
    Thread trader = new Thread(traderRunnable);
    producer.start();
    try {
      sleep(400);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    trader.start();
    assertEquals(2, warehouse.getProducts().size());
  }
}
