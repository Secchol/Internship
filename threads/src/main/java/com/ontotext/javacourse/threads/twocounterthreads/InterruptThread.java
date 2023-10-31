package com.ontotext.javacourse.threads.twocounterthreads;

public class InterruptThread extends Thread {
  private final int count;
  private Thread otherThread;

  public InterruptThread(int count) {
    this.count = count;
  }

  public void setOtherThread(Thread thread) {
    this.otherThread = thread;
  }

  @Override
  public void run() {
    int startCount = 0;
    while (startCount <= count) {
      System.out.printf("%s count is: %d%n", Thread.currentThread().getName(), startCount);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.printf("%s has been interrupted!%n", Thread.currentThread().getName());
        return;
      }
      startCount++;
    }
    otherThread.interrupt();
  }
}
