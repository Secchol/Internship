package com.ontotext.javacourse.collections.cache;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LRUCacheTest {
  private LRUCache<Integer, String> cache;

  @BeforeEach
  void setUp() {
    cache = new LRUCache<>(4);
    cache.put(1, "a");
    cache.put(2, "b");
    cache.put(3, "c");
  }

  @Test
  void getReturnsElementValueIfKeyIsPresentInCache() {
    assertEquals("c", cache.get(3));
  }

  @Test
  void getReturnsNullIfKeyIsNotPresentInCache() {
    assertNull(cache.get(10));
  }

  @Test
  void putCreatesNewElementInCache() {
    cache.put(4, "d");
    assertTrue(cache.getCache().containsKey(4));
  }

  @Test
  void putEvictsOldestElementAndCreatesNewElementIfSizeIsReached() {
    cache.put(4, "d");
    cache.put(5, "e");
    assertFalse(cache.getCache().containsKey(1));
    assertTrue(cache.getCache().containsKey(5));
  }

  @Test
  void putThrowsExceptionIfInputKeyIsNull() {
    assertThrows(IllegalArgumentException.class, () -> cache.put(null, "10"));
  }

  @Test
  void putBringsElementToFrontIfItAlreadyContainsKey() {
    cache.put(1, "bb");
    cache.put(4, "dd");
    cache.put(5, "ggg");
    assertFalse(cache.getCache().containsKey(2));
    assertEquals("bb", cache.getCache().get(1));
  }
}
