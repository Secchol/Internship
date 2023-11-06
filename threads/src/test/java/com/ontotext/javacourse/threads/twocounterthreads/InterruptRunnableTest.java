package com.ontotext.javacourse.threads.twocounterthreads;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

class InterruptRunnableTest {
  @Test
  void lowerCountThreadInterruptsOtherThreadAndFinishesItsOwnExecution() {
    InterruptRunnable lowerCountRunnable = new InterruptRunnable(5);
    InterruptRunnable higherCountRunnable = new InterruptRunnable(10);
    Thread lowerCountThread = new Thread(lowerCountRunnable);
    Thread higherCountThread = new Thread(higherCountRunnable);
    lowerCountThread.start();
    higherCountThread.start();
    Awaitility.await().atMost(200, TimeUnit.MILLISECONDS).until(higherCountThread::isInterrupted);
    Awaitility.await().atMost(200, TimeUnit.MILLISECONDS).until(() -> !lowerCountThread.isAlive());
    assertTrue(higherCountThread.isInterrupted() && !lowerCountThread.isAlive());
  }
}
