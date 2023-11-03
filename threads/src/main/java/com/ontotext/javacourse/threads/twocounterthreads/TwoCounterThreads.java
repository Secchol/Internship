package com.ontotext.javacourse.threads.twocounterthreads;

/** The TwoCounterThreads class creates and starts two instances of the InterruptThread class. */
public class TwoCounterThreads {
  private static final int LOWER_COUNT = 5;
  private static final int HIGHER_COUNT = 10;

  public void start() {
    InterruptThread firstThread = new InterruptThread(LOWER_COUNT);
    InterruptThread secondThread = new InterruptThread(HIGHER_COUNT);
    firstThread.setThreadToStop(secondThread);
    secondThread.setThreadToStop(firstThread);
    firstThread.start();
    secondThread.start();
  }
}
