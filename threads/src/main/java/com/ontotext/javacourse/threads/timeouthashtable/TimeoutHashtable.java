package com.ontotext.javacourse.threads.timeouthashtable;

import java.util.Hashtable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.Getter;

/**
 * The TimeoutHashtable class is a collection that stores elements for a configured amount of time.
 * When a key is not accessed for the configured amount of time, it’s removed from the table.
 */
@Getter
public class TimeoutHashtable {
  private final Hashtable<String, Object> hashtable;
  private final long timeout;
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

  public TimeoutHashtable(long timeout) {
    hashtable = new Hashtable<>();
    this.timeout = timeout;
  }

  /**
   * Adds the key and value to the hashtable or if the key exists in the table, then it’s value gets
   * replaced with the new one. Adds the item to the scheduler(if the timeout is reached the item is
   * removed).
   *
   * @param key the key
   * @param value the value
   */
  public void put(String key, Object value) {
    if (!hashtable.containsKey(key)) {
      hashtable.put(key, "");
    }
    hashtable.put(key, new Item(value));
    scheduleDelete(key);
  }

  /**
   * Gets an object by the provided key.
   *
   * @param key the key of the value to get
   * @return the object by the provided key or null if it is not found
   */
  public Object get(String key) {
    if (!hashtable.containsKey(key)) {
      return null;
    }
    Item item = (Item) hashtable.get(key);
    item.setLastAccessTime(System.currentTimeMillis());
    return item.getValue();
  }

  /**
   * Removes a value by a given key.
   *
   * @param key the key of the value to remove
   * @return the deleted value or null if the key doesn’t exist in the table
   */
  public Object remove(String key) {
    if (!hashtable.containsKey(key)) {
      return null;
    }
    Item item = (Item) hashtable.remove(key);
    return item.getValue();
  }

  private void scheduleDelete(String key) {
    scheduler.schedule(
        () -> {
          if (hashtable.get(key) != null) {
            Item item = (Item) hashtable.get(key);
            long currentTime = System.currentTimeMillis();
            if (currentTime - item.getLastAccessTime() >= timeout) {
              hashtable.remove(key);
            }
          }
        },
        timeout,
        TimeUnit.MILLISECONDS);
  }
}
