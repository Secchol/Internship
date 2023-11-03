package com.ontotext.javacourse.threads.stopcounterthread;

import java.util.Scanner;
import lombok.AllArgsConstructor;

/**
 * The Counter class contains a method that starts a thread that counts on every second and
 * interrupts it when user input is given.
 */
@AllArgsConstructor
public class Counter {
  private static final Scanner scanner = new Scanner(System.in);
  private final int count;

  private Counter() throws IllegalAccessException {
    throw new IllegalAccessException("Counter class is not meant to be instantiated!");
  }

  /** Starts the counter thread. */
  public void start() {
    CounterRunnable runnable = new CounterRunnable(this.count);
    Thread counterThread = new Thread(runnable);
    System.out.println("Starting counter thread");
    counterThread.start();
    System.out.println("Enter any symbol to stop the counting thread:");
    scanner.nextLine();
    counterThread.interrupt();
    System.out.println("Thread is stopped!");
  }
}
