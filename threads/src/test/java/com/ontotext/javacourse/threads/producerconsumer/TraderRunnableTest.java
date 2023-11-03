package com.ontotext.javacourse.threads.producerconsumer;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class TraderRunnableTest {

  private static final List<Object> PRODUCTS = List.of("a", "b", "c");
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
    try {
      sleep(600);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(1, warehouse.getProducts().size());
  }

  @Test
  void traderBuysProductsFromWarehouseInGivenDelay() {
    setUp(5, 3);
    trader.start();
    try {
      sleep(150);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(2, warehouse.getProducts().size());
  }

  @Test
  void traderWaitsForProductToBeAddedIfWarehouseIsEmpty() {
    setUp(3, 4);
    trader.start();
    try {
      sleep(400);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    ProducerRunnable producerRunnable =
        new ProducerRunnable("Mr.Producer", warehouse, List.of(10), 200);
    Thread producer = new Thread(producerRunnable);
    producer.start();
    assertEquals(0, warehouse.getProducts().size());
  }
}
