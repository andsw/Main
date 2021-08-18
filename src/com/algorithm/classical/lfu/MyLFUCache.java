package com.algorithm.classical.lfu;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MyLFUCache {

  static class Node implements Comparable<Node> {
    int key;
    int value;
    int count;
    int time;

    public Node(int key, int value, int count, int time) {
      this.key = key;
      this.value = value;
      this.count = count;
      this.time = time;
    }

    @Override
    public int compareTo(Node o) {
      if (count == o.count) {
        return Integer.compare(time, o.time);
      }
      return Integer.compare(count, o.count);
    }
  }

  private final Map<Integer, Node> map;
  private final int capacity;
  private int time = 1;
  private final TreeSet<Node> set;

  public MyLFUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
    set = new TreeSet<>();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    Node val = map.get(key);
    set.remove(val);
    val.count++;
    val.time = time++;
    set.add(val);
    return val.value;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    Node node;
    if (map.containsKey(key)) {
      node = map.get(key);
      set.remove(node);
      node.value = value;
      node.count++;
      node.time = time++;
      map.put(key, node);
    } else {
      node = new Node(key, value, 1, time++);
      map.put(key, node);
    }
    if (map.size() > capacity) {
      Node first = set.pollFirst();
      if (first != null) {
        map.remove(first.key);
      }
    }
    set.add(node);
  }

  public static void main(String[] args) {
    MyLFUCache cache = new MyLFUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));
    cache.put(3, 3);
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));
    cache.put(4, 4);
    System.out.println(cache.get(1));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));
  }
}