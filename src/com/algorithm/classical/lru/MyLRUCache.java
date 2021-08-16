package com.algorithm.classical.lru;

import java.util.HashMap;
import java.util.Map;

public class MyLRUCache {
  private static class Entry {
    public Integer key;
    public Integer val;
    public Entry next;
    public Entry prev;

    public Entry(Integer key, Integer val) {
      this.key = key;
      this.val = val;
    }
  }
  private Entry head;
  private Entry tail;
  private final Integer capacity;
  private final Map<Integer, Entry> map;

  public MyLRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>(capacity);
  }

  public Integer get(Integer key) {
    Entry entry = map.get(key);
    if (entry == null) {
      return null;
    }
    if (entry.next != null) {
      entry.next.prev = entry.prev;
    }
    if (entry.prev != null) {
      entry.prev.next = entry.next;
      entry.prev = null;
    }
    entry.next = head;
    head = entry;
    return entry.val;
  }

  public void put(Integer key, Integer val) {
    if (map.size() == capacity) {
      map.remove(tail.key);
      Entry temp = tail.prev;
      tail.prev.next = null;
      tail.prev = null;
      tail = temp;
    }
    Entry value = new Entry(key, val);
    value.next = head;
    if (head != null) {
      head.prev = value;
    } else {
      tail = value;
    }
    head = value;
    map.put(key, value);
  }

  public static void main(String[] args) {
    int capacity = 4;
    MyLRUCache lruCache = new MyLRUCache(capacity);
    for (int i = 0; i < 100; i++) {
      lruCache.put(i, i);
    }
    for (int i = 100 - capacity - 3; i < 100; i++) {
      System.out.println(lruCache.get(i));
    }
  }
}