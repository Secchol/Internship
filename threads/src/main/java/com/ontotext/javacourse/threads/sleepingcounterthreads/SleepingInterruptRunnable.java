package com.ontotext.javacourse.threads.sleepingcounterthreads;

import static java.lang.Thread.sleep;

import java.util.concurrent.atomic.AtomicBoolean;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The SleepInterruptRunnable class defines a runnable that counts to a given count and after each
 * count the thread waits for a given interval. When it reaches that count it stops the other
 * thread's execution and then finishes its own.
 */
@AllArgsConstructor
public class SleepingInterruptRunnable implements Runnable {
  private static final Logger LOGGER = LoggerFactory.getLogger(SleepingInterruptRunnable.class);
  private static final AtomicBoolean SHOULD_STOP_WORKING = new AtomicBoolean(false);
  private static final AtomicBoolean OTHER_THREAD_IS_TERMINATED = new AtomicBoolean(false);
  private static final Object LOCK = new Object();
  private final int count;
  private final long sleepTime;

  @Override
  public void run() {
    int currentCount = 1;
    while (!SHOULD_STOP_WORKING.get() && currentCount <= count) {
      LOGGER.info("{} count: {}", Thread.currentThread().getName(), currentCount);
      currentCount++;
      try {
        sleep(sleepTime);
      } catch (InterruptedException exception) {
        Thread.currentThread().interrupt();
      }
    }
    synchronized (LOCK) {
      if (SHOULD_STOP_WORKING.get()) {
        interruptThread();
        LOCK.notify();
        return;
      }
      indicateToStopThread();
      LOGGER.info("{} is waiting for other thread to terminate", Thread.currentThread().getName());
      try {
        while (!OTHER_THREAD_IS_TERMINATED.get()) {
          LOCK.wait();
        }
      } catch (InterruptedException e) {
        interruptThread();
        return;
      }
      LOGGER.info("{} has finished its execution", Thread.currentThread().getName());
    }
  }

  private void indicateToStopThread() {
    SHOULD_STOP_WORKING.set(true);
  }

  private void indicateThatOtherThreadIsTerminated() {
    OTHER_THREAD_IS_TERMINATED.set(true);
  }

  private void interruptThread() {
    LOGGER.info("{} has been interrupted!", Thread.currentThread().getName());
    indicateThatOtherThreadIsTerminated();
    Thread.currentThread().interrupt();
  }
}
