package com.algorithm.classical.lru;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
  private Integer capacity;

  public LRUCache(int capacity) {
    super(capacity);
  }

  @Override
  public boolean removeEldestEntry(Entry<Integer, Integer> entry) {
    return size() == capacity;
  }
}