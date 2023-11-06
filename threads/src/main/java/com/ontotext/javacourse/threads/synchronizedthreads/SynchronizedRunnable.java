package com.ontotext.javacourse.threads.synchronizedthreads;

import java.util.concurrent.atomic.AtomicBoolean;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The SynchronizedRunnable class defines a runnable that counts once and stops, so it allows the
 * other thread to count, etc.
 */
@AllArgsConstructor
public class SynchronizedRunnable implements Runnable {
  private static final Logger LOGGER = LoggerFactory.getLogger(SynchronizedRunnable.class);
  private static final AtomicBoolean SHOULD_RUN = new AtomicBoolean(false);
  private final int count;

  @Override
  public void run() {
    int currentCount = 1;
    while (currentCount <= count) {
      while (!SHOULD_RUN.compareAndSet(false, true)) {}
      LOGGER.info("{} count : {}", Thread.currentThread().getName(), currentCount++);
      SHOULD_RUN.set(false);
    }
    LOGGER.info("{} finished execution", Thread.currentThread().getName());
  }
}
