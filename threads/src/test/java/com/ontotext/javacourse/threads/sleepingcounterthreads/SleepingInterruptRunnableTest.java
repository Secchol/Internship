package com.ontotext.javacourse.threads.sleepingcounterthreads;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

class SleepingInterruptRunnableTest {
  @Test
  void lowerCountThreadInterruptsOtherThreadAndFinishesItsOwnExecution() {
    SleepingInterruptRunnable lowerCountRunnable = new SleepingInterruptRunnable(5, 100);
    SleepingInterruptRunnable higherCountRunnable = new SleepingInterruptRunnable(10, 100);
    Thread lowerCountThread = new Thread(lowerCountRunnable);
    Thread higherCountThread = new Thread(higherCountRunnable);
    lowerCountThread.start();
    higherCountThread.start();
    Awaitility.await().atMost(700, TimeUnit.MILLISECONDS).until(higherCountThread::isInterrupted);
    Awaitility.await().atMost(700, TimeUnit.MILLISECONDS).until(() -> !lowerCountThread.isAlive());
    assertTrue(higherCountThread.isInterrupted() && !lowerCountThread.isAlive());
  }

  @Test
  void higherCountThreadWithLessIntervalTimeInterruptsLowerCountThread() {
    SleepingInterruptRunnable lowerCountRunnable = new SleepingInterruptRunnable(5, 500);
    SleepingInterruptRunnable higherCountRunnable = new SleepingInterruptRunnable(10, 100);
    Thread lowerCountThread = new Thread(lowerCountRunnable);
    Thread higherCountThread = new Thread(higherCountRunnable);
    lowerCountThread.start();
    higherCountThread.start();
    Awaitility.await().atMost(2000, TimeUnit.MILLISECONDS).until(lowerCountThread::isInterrupted);
    Awaitility.await()
        .atMost(2000, TimeUnit.MILLISECONDS)
        .until(() -> !higherCountThread.isAlive());
    assertTrue(lowerCountThread.isInterrupted() && !higherCountThread.isAlive());
  }
}
