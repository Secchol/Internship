package com.ontotext.javacourse.threads.timeouthashtable;

import lombok.Getter;
import lombok.Setter;

/** The Item class defines an item that contains its value and the time of its last access. */
@Getter
@Setter
public class Item {
  private long lastAccessTime;
  private Object value;

  public Item(Object value) {
    this.value = value;
    lastAccessTime = System.currentTimeMillis();
  }
}
