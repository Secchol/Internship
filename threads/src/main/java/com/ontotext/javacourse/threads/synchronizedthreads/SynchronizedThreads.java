package com.ontotext.javacourse.threads.synchronizedthreads;

/**
 * The SynchronizedThreads class contains a start method that creates and starts two threads that
 * use the SynchronizedRunnable.
 */
public class SynchronizedThreads {
  /**
   * Starts the synchronized threads.
   *
   * @param count the number which the threads will count to
   */
  public void start(int count) {
    Object lock = new Object();
    Thread firstThread = new Thread(new SynchronizedRunnable(count, lock));
    Thread secondThread = new Thread(new SynchronizedRunnable(count, lock));
    firstThread.start();
    secondThread.start();
  }
}
