package com.ontotext.javacourse.threads.stopcounterthread;

import lombok.AllArgsConstructor;

/**
 * The CounterRunnable class defines a runnable that counts on every second until a configured count
 * is reached.
 */
@AllArgsConstructor
public class CounterRunnable implements Runnable {
  private final int count;

  @Override
  public void run() {
    for (int i = 1; i <= this.count; i++) {
      System.out.println("Current count: " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("Thread has been interrupted!");
        System.out.printf("Reached count: %d%n", i);
        return;
      }
    }
    System.out.println("Thread reached count!");
  }
}
