package com.ontotext.javacourse.collections.cache;

import java.util.*;
import lombok.Getter;
import lombok.ToString;

/**
 * The LRU cache is a data structure with a set size that evicts the least recently used element
 * when the size is reached.
 *
 * @param <K> the cache key
 * @param <V> the cache value
 */
@Getter
@ToString
public class LRUCache<K, V> {
  private final int size;
  private final Map<K, V> cache;

  /**
   * Sets the size of the cache and overrides the removeEldestEntry method so that an element is
   * evicted when the cache size is reached
   *
   * @param size the size of the cache
   */
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
