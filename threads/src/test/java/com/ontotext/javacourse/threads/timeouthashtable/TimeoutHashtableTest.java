package com.ontotext.javacourse.threads.timeouthashtable;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
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
    assertEquals(3, hashtable.get("a"));
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
    Awaitility.await()
        .atMost(200, TimeUnit.MILLISECONDS)
        .pollInterval(100, TimeUnit.MILLISECONDS)
        .until(() -> hashtable.getHashtable().size() == 0);
    assertEquals(0, hashtable.getHashtable().size());
  }

  @Test
  void keyIsNotRemovedIfReaccessedByPut() throws InterruptedException {
    hashtable.put("a", 3);
    sleep(60);
    hashtable.put("a", 4);
    Awaitility.await()
        .atMost(500, TimeUnit.MILLISECONDS)
        .pollInterval(50, TimeUnit.MILLISECONDS)
        .until(() -> hashtable.getHashtable().size() == 1);
    assertEquals(1, hashtable.getHashtable().size());
  }

  @Test
  void keyIsNotRemovedIfReaccessedByGet() throws InterruptedException {
    hashtable.put("a", 3);
    sleep(60);
    hashtable.get("a");
    sleep(60);
    assertEquals(1, hashtable.getHashtable().size());
  }
}
