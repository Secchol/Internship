package com.ontotext.javacourse.threads;

import com.ontotext.javacourse.threads.twocounterthreads.TwoCounterThreads;

public class Runner {
  public static void main(String[] args) {


    TwoCounterThreads threads = new TwoCounterThreads();
    threads.start();
  }
}
