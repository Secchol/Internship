package com.ontotext.javacourse.collections.cache;

import java.util.*;
import lombok.Getter;
import lombok.ToString;

/**
 * The LRUCache class defines an LRU cache that contains methods for adding and retrieving elements
 * from the cache.
 *
 * @param <K> the cache key
 * @param <V> the cache value
 */
@Getter
@ToString
public class LRUCache<K, V> {
  private final int size;

  private final LinkedHashMap<K, V> cache;

  public LRUCache(int size) {
    this.size = size;
    this.cache =
        new LinkedHashMap<>(size, 0.75f, true) {
          @Override
          protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > LRUCache.this.size;
          }
        };
  }

  /**
   * Returns the element value by its key. If the element is not present in the cache returns null.
   *
   * @param key the element's key
   * @return the element's value
   */
  public V get(K key) {
    return cache.getOrDefault(key, null);
  }

  /**
   * Creates a new element in the LRU cache and adds it to the front.
   *
   * @param key the element's key
   * @param value the element's value
   */
  public void put(K key, V value) {
    if (key == null) {
      throw new IllegalArgumentException("Key cannot be null!");
    }
    cache.put(key, value);
  }
}
