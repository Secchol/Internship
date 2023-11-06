package com.ontotext.javacourse.threads.stopcounterthread;

import java.io.IOException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The CounterRunnable class defines a runnable that counts on every second until a configured count
 * is reached. After the thread is started it waits for a keyboard input event. Once the input is
 * registered the thread is stopped. If not keyboard input event is registered before the thread
 * reaches its given count it is terminated.
 */
@AllArgsConstructor
public class CounterRunnable implements Runnable {
  private static final Logger LOGGER = LoggerFactory.getLogger(CounterRunnable.class);
  private final int count;

  @Override
  public void run() {
    int currentCount = 0;
    while (currentCount <= count && !Thread.currentThread().isInterrupted()) {
      LOGGER.info("Current count: {}", ++currentCount);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      try {
        if (System.in.available() > 0) {
          LOGGER.info("Keyboard input detected. Interrupting the thread.");
          Thread.currentThread().interrupt();
        }
      } catch (IOException e) {
        LOGGER.error(e.getMessage());
        return;
      }
    }
    if (currentCount <= count) {
      LOGGER.info("Counter was interrupted. Reached count {}.", currentCount);
    } else {
      LOGGER.info("Thread reached count!");
    }
  }
}
