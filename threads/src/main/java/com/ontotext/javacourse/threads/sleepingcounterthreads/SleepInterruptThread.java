package com.ontotext.javacourse.threads.sleepingcounterthreads;

import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
public class SleepInterruptThread extends Thread {
  private static final Logger LOGGER = LoggerFactory.getLogger(SleepInterruptThread.class);
  private final int count;
  private final long sleepTime;
  private Thread threadToStop;

  public SleepInterruptThread(int count, int sleepTime) {
    this.count = count;
    this.sleepTime = sleepTime;
  }

  @Override
  public void run() {
    int currentCount = 1;
    while (!Thread.currentThread().isInterrupted() && currentCount <= count) {
      LOGGER.info("{} count: {}", Thread.currentThread().getName(), currentCount);
      currentCount++;
      try {
        sleep(sleepTime);
      } catch (InterruptedException exception) {
        LOGGER.info("{} has been interrupted!", Thread.currentThread().getName());
        return;
      }
    }
    if (Thread.currentThread().isInterrupted()) {
      LOGGER.info("{} has been interrupted!", Thread.currentThread().getName());
      return;
    }
    threadToStop.interrupt();
    LOGGER.info("{} has finished its execution", Thread.currentThread().getName());
  }
}
