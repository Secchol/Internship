package com.ontotext.javacourse.threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Warehouse class defines a warehouse that has a given capacity. The warehouse can add products
 * produced by producers to its inventory and sell products to traders that want to buy them.
 */
public class Warehouse {
  private static final Logger LOGGER = LoggerFactory.getLogger(Warehouse.class);
  private final int capacity;
  private final Queue<Object> products;
  private final ReentrantLock lock;
  private final Condition itemAddedCondition;
  private final Condition itemRemovedCondition;

  /**
   * Sets the capacity to the given value and initializes the lock and conditions.
   *
   * @param capacity the capacity of the warehouse
   */
  public Warehouse(int capacity) {
    this.capacity = capacity;
    products = new LinkedList<>();
    lock = new ReentrantLock();
    itemAddedCondition = lock.newCondition();
    itemRemovedCondition = lock.newCondition();
  }

  public Queue<Object> getProducts() {
    return this.products;
  }
  /**
   * Adds a product produced by a given producer. If the warehouse capacity is reached the producer
   * waits until a trader buys a product and frees up space.
   *
   * @param producerName the name of the product producer
   * @param product the product to add to the warehouse
   */
  public void addProduct(String producerName, Object product) {
    lock.lock();
    try {
      while (products.size() == capacity) {
        LOGGER.info("{} is waiting for free space.", producerName);
        itemRemovedCondition.await();
      }
      products.add(product);
      LOGGER.info("New item has been added to warehouse by {}.", producerName);
      itemAddedCondition.signalAll();
    } catch (InterruptedException exception) {
      Thread.currentThread().interrupt();
    } finally {
      lock.unlock();
    }
  }

  /**
   * Sells a product to a trader. If the warehouse is empty then the trader waits until a product is
   * added and buys it.
   *
   * @param traderName the name of the product buyer
   */
  public void buyProduct(String traderName) {
    lock.lock();
    try {
      while (products.isEmpty()) {
        LOGGER.info("{} is waiting for available products.", traderName);
        itemAddedCondition.await();
      }
      products.remove();
      LOGGER.info("{} bought a product.", traderName);
      itemRemovedCondition.signalAll();
    } catch (InterruptedException exception) {
      Thread.currentThread().interrupt();
    } finally {
      lock.unlock();
    }
  }
}
