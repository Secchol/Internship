package com.ontotext.javacourse.threads.synchronizedthreads;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SynchronizedThreadsTest {
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private SynchronizedThreads synchronizedThreads;

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outputStream));
    synchronizedThreads = new SynchronizedThreads();
  }

  @Test
  void startStartsThreadsAndTheyDisplayCorrectOutput() {
    synchronizedThreads.start(5);
    try {
      sleep(50);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(
        outputStream.toString().trim(),
        "Thread-0 count: 1"
            + System.lineSeparator()
            + "Thread-1 count: 1"
            + System.lineSeparator()
            + "Thread-0 count: 2"
            + System.lineSeparator()
            + "Thread-1 count: 2"
            + System.lineSeparator()
            + "Thread-0 count: 3"
            + System.lineSeparator()
            + "Thread-1 count: 3"
            + System.lineSeparator()
            + "Thread-0 count: 4"
            + System.lineSeparator()
            + "Thread-1 count: 4"
            + System.lineSeparator()
            + "Thread-0 count: 5"
            + System.lineSeparator()
            + "Thread-1 count: 5");
  }
}
