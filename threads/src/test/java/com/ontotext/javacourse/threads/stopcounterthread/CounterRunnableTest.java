package com.ontotext.javacourse.threads.stopcounterthread;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

class CounterRunnableTest {

  @Test
  void counterThreadIsInterruptedWhenUserInputIsRegistered() throws InterruptedException {
    CounterRunnable counterRunnable = new CounterRunnable(10);
    Thread counterThread = new Thread(counterRunnable);
    counterThread.start();
    sleep(5000);
    ByteArrayInputStream keyboardInput = new ByteArrayInputStream("Input event".getBytes());
    System.setIn(keyboardInput);
    Awaitility.await().until(counterThread::isInterrupted);
    assertTrue(counterThread.isInterrupted());
  }
}
