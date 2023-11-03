package com.ontotext.javacourse.threads.timeouthashtable;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeoutHashtableTest {

  private TimeoutHashtable hashtable;

  @BeforeEach
  void setUp() {
    hashtable = new TimeoutHashtable(100);
  }

  @Test
  void putAddsNewElementToHashtable() {
    hashtable.put("a", 2);
    hashtable.put("b", 3);
    assertEquals(2, hashtable.getHashtable().size());
  }

  @Test
  void putReplacesOldValueIfKeyExists() {
    hashtable.put("a", 2);
    hashtable.put("a", 3);
    assertEquals(hashtable.get("a"), 3);
  }

  @Test
  void getReturnsObjectByProvidedKey() {
    hashtable.put("a", 3);
    assertEquals(3, hashtable.get("a"));
  }

  @Test
  void getReturnsNullIfProvidedKeyDoesNotExist() {
    assertNull(hashtable.get("missingKey"));
  }

  @Test
  void removeDeletesValueFromHashtable() {
    hashtable.put("a", 3);
    hashtable.remove("a");
    assertEquals(0, hashtable.getHashtable().size());
  }

  @Test
  void removeReturnsDeletedKeyValue() {
    hashtable.put("a", 3);
    assertEquals(3, hashtable.remove("a"));
  }

  @Test
  void removeReturnsNullIfKeyDoesNotExist() {
    assertNull(hashtable.remove("missingKey"));
  }

  @Test
  void keyIsRemovedWhenNotAccessed() {
    hashtable.put("a", 3);
    hashtable.put("b", 4);
    try {
      sleep(200);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(0, hashtable.getHashtable().size());
  }

  @Test
  void keyIsNotRemovedIfReaccessedByPut() {
    hashtable.put("a", 3);
    try {
      sleep(60);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    hashtable.put("a", 4);
    try {
      sleep(60);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(1, hashtable.getHashtable().size());
  }

  @Test
  void keyIsNotRemovedIfReaccessedByGet() {
    hashtable.put("a", 3);
    try {
      sleep(60);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    hashtable.get("a");
    try {
      sleep(60);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(1, hashtable.getHashtable().size());
  }
}
