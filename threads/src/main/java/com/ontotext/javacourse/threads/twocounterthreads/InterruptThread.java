package com.ontotext.javacourse.threads.twocounterthreads;

import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
public class InterruptThread extends Thread {
  private static final Logger LOGGER = LoggerFactory.getLogger(InterruptThread.class);
  private final int count;
  private Thread threadToStop;

  public InterruptThread(int count) {
    this.count = count;
  }

  @Override
  public void run() {
    int currentCount = 1;
    while (!Thread.currentThread().isInterrupted() && currentCount <= count) {
      LOGGER.info("{} count: {}", Thread.currentThread().getName(), currentCount);
      currentCount++;
    }
    if (Thread.currentThread().isInterrupted()) {
      LOGGER.info("{} has been interrupted!", Thread.currentThread().getName());
      return;
    }
    threadToStop.interrupt();
    LOGGER.info("{} has finished its execution", Thread.currentThread().getName());
  }
}
