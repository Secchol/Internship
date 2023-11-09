package com.ontotext.javacourse.threads.twocounterthreads;

import java.util.concurrent.atomic.AtomicBoolean;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The InterruptRunnable class defines a runnable that counts to a given count and when it reaches
 * that count it stops the other thread's execution and finishes its own.
 */
@AllArgsConstructor
public class InterruptRunnable implements Runnable {
  private static final Logger LOGGER = LoggerFactory.getLogger(InterruptRunnable.class);
  private static final AtomicBoolean SHOULD_STOP_WORKING = new AtomicBoolean(false);
  private static final AtomicBoolean threadTerminated = new AtomicBoolean(false);
  private final int count;

  @Override
  public void run() {
    int currentCount = 1;
    while (!SHOULD_STOP_WORKING.get() && currentCount <= count) {
      LOGGER.info("{} count: {}", Thread.currentThread().getName(), currentCount);
      currentCount++;
    }
    if (SHOULD_STOP_WORKING.get()) {
      LOGGER.info("{} has been interrupted!", Thread.currentThread().getName());
      indicateThatThreadIsStopped();
      Thread.currentThread().interrupt();
      return;
    }
    indicateToStopThread();
    LOGGER.info("{} is waiting for other thread to terminate", Thread.currentThread().getName());
    while (!threadTerminated.get()) {}
    LOGGER.info("{} has finished its execution", Thread.currentThread().getName());
  }

  private void indicateToStopThread() {
    SHOULD_STOP_WORKING.set(true);
  }

  private void indicateThatThreadIsStopped() {
    threadTerminated.set(true);
  }
}
