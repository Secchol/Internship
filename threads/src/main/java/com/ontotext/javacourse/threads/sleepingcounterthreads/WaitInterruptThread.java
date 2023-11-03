package com.ontotext.javacourse.threads.sleepingcounterthreads;

import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
public class WaitInterruptThread extends Thread {
  private static final Logger LOGGER = LoggerFactory.getLogger(WaitInterruptThread.class);
  private final int count;
  private Thread threadToStop;

  public WaitInterruptThread(int count) {
    this.count = count;
  }

  @Override
  public void run() {
    int currentCount = 1;
    while (!Thread.currentThread().isInterrupted() && currentCount <= count) {
      LOGGER.info("{} count: {}", Thread.currentThread().getName(), currentCount);
      currentCount++;
    }
    synchronized (this) {
      if (Thread.currentThread().isInterrupted()) {
        LOGGER.info("{} has been interrupted!", Thread.currentThread().getName());
        notify();
        return;
      }
      threadToStop.interrupt();
      try {
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      LOGGER.info("{} has finished its execution", Thread.currentThread().getName());
    }
  }
}
