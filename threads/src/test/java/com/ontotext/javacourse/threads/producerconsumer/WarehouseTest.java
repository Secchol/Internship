package com.ontotext.javacourse.threads.producerconsumer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarehouseTest {
  private Warehouse warehouse;

  @BeforeEach
  void setUp() {
    warehouse = new Warehouse(5);
  }

  @Test
  void addProductAddsProductToWarehouse() {
    for (int i = 0; i < 5; i++) {
      warehouse.addProduct("Ivan", i);
    }
    assertEquals(5, warehouse.getProducts().size());
  }

  @Test
  void buyProductRemovesProductsFromWarehouse() {
    for (int i = 0; i < 5; i++) {
      warehouse.addProduct("Ivan", i);
    }
    for (int i = 0; i < 4; i++) {
      warehouse.buyProduct("Random");
    }
    assertEquals(1, warehouse.getProducts().size());
  }
}
