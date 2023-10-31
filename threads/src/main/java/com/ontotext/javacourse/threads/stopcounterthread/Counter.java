package com.ontotext.javacourse.threads.stopcounterthread;

import java.util.Scanner;

/**
 * The Counter class contains a method that starts a thread that counts on every second and
 * interrupts it when user input is given.
 */
public final class Counter {
  private static final Scanner scanner = new Scanner(System.in);

  private Counter() throws IllegalAccessException {
    throw new IllegalAccessException("Counter class is not meant to be instantiated!");
  }

  /** Starts the counter thread. */
  public static void start() {
    System.out.println("Enter count:");
    int count = scanner.nextInt();
    scanner.nextLine();
    CounterRunnable runnable = new CounterRunnable(count);
    Thread counterThread = new Thread(runnable);
    counterThread.start();
    System.out.println("Enter any symbol to stop the counting thread:");
    scanner.nextLine();
    counterThread.interrupt();
    System.out.println("Thread is stopped!");
  }
}
