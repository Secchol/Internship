package com.ontotext.javacourse.designpatterns.proxy;

/** Defines the internet which can connect a client to a given url. */
public interface Internet {
  boolean connectTo(String url);
}
