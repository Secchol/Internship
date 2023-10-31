package com.ontotext.javacourse.threads.twocounterthreads;

public class TwoCounterThreads {
  public void start() {
    InterruptThread firstThread = new InterruptThread(10);
    InterruptThread secondThread = new InterruptThread(5);
    firstThread.setOtherThread(secondThread);
    secondThread.setOtherThread(firstThread);
    firstThread.start();
    secondThread.start();
  }
}
