package com.ontotext.javacourse.threads.synchronizedthreads;

import lombok.AllArgsConstructor;

/**
 * The SynchronizedRunnable class defines a runnable that counts once and stops, so it allows the
 * other thread to count, etc.
 */
@AllArgsConstructor
public class SynchronizedRunnable implements Runnable {
  private final int count;
  private final Object lock;

  @Override
  public void run() {
    synchronized (lock) {
      for (int i = 1; i <= count; i++) {
        System.out.printf("%s count: %d%n", Thread.currentThread().getName(), i);
        try {
          lock.notify();
          lock.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}
