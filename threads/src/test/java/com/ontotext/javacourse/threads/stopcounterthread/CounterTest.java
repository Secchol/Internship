package com.ontotext.javacourse.threads.stopcounterthread;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class CounterTest {

  private Counter counter;
  private ByteArrayOutputStream outputStream;

  @Test
  void startStopsCounterWhenKeyboardInputEventIsEntered() {
    setUp("stop\n");
    counter.start();
    try {
      sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.setOut(System.out);
    assertTrue(
        outputStream.toString().contains("Thread has been interrupted!\r\n" + "Reached count: 1\r\n"));
  }

  private void setUp(String inputString) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    outputStream = new ByteArrayOutputStream();
    System.setIn(inputStream);
    System.setOut(new PrintStream(outputStream));
    counter = new Counter(5);
  }
}
