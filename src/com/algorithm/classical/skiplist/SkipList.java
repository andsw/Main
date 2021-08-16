package com.algorithm.classical.skiplist;

import java.util.ArrayList;
import java.util.List;

public class SkipList<S extends Comparable<S>, T> {

  private static final float LEVEL_RIGHT = 0.5F;

  private final Node<S, T> head;

  private final Integer maxLevel;

  private SkipList(Integer capacity) {
    maxLevel = (int) (Math.log(capacity) / Math.log(2)) + 1;
    head = new Node<>(maxLevel - 1, null, null);
    Node<S, T> temp = head;
    for (int i = maxLevel - 2; i >= 0; i--) {
      temp.down = new Node<>(i, null, null);
      temp = temp.down;
    }
  }

  /**
   * @param key
   * @param value
   */
  public void put(S key, T value) {
    Node<S, T> temp = head;
    List<Node<S, T>> pres = new ArrayList<>();
    while (temp != null) {
      if (temp.key != null && temp.key.equals(key)) {
        break;
      } else {
        if (temp.next == null || temp.next.key.compareTo(key) > 0) {
          pres.add(temp);
          temp = temp.down;
        } else {
          temp = temp.next;
        }
      }
    }
    if (temp == null) {
      int level = randomLevel();
      Node<S, T> down = null;
      for (int i = 0; i <= level; i++) {
        Node<S, T> stNode = pres.get(pres.size() - 1 - i);
        Node<S, T> newNode = new Node<>(stNode.level, key, value);
        Node<S, T> stNodeNext = stNode.next;
        stNode.next = newNode;
        newNode.next = stNodeNext;
        newNode.down = down;
        down = newNode;
      }
    } else {
      while (temp != null) {
        temp.value = value;
        temp = temp.down;
      }
    }
  }

  public T get(S key) {
    Node<S, T> temp = head;
    while (temp != null) {
      if (temp.key != null && temp.key.equals(key)) {
        return temp.value;
      } else {
        if (temp.next == null || temp.next.key.compareTo(key) > 0) {
          temp = temp.down;
        } else {
          temp = temp.next;
        }
      }
    }
    return null;
  }

  public void remove(S key) {
    Node<S, T> temp = head;
    while (temp != null) {
      if (temp.next != null && temp.next.key.equals(key)) {
        Node<S, T> tt = temp.next;
        temp.next = temp.next.next;
        tt.next = null;
        temp = temp.down;
      } else if (temp.next == null || temp.next.key.compareTo(key) > 0) {
        temp = temp.down;
      } else {
        temp = temp.next;
      }
    }
  }

  public static <S, T> void printWithFormat(Node<S, T> head) {
    if (head == null) {
      return;
    }
    Node<S, T> temp = head;
    while (head != null) {
      if (head.key != null) {
        System.out.print(head.key + " ");
      }
      head = head.next;
    }
    System.out.println();
    printWithFormat(temp.down);
  }

  /**
   * 返回索引最高层数
   *
   * @return 为0则不建立索引，否则建立 [1, level] 所有层级索引
   */
  private int randomLevel() {
    int level = 0;
    while (Math.random() < LEVEL_RIGHT && maxLevel != null && level < maxLevel - 1) {
      level++;
    }
    return level;
  }

  private static class Node<S, T> {

    private final Integer level;
    private final S key;
    private T value;
    private Node<S, T> next;
    private Node<S, T> down;

    public Node(int level, S key, T value) {
      this.level = level;
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    SkipList<Integer, Integer> skipList = new SkipList<>(100);
    for (int i = 0; i < 150; i++) {
      int ii = (int) (Math.random() * 10 + Math.random() * 10 + Math.random() * 10);
      skipList.put(ii, ii);
    }
    System.out.println(skipList.get(8));
    System.out.println(skipList.get(3));
    printWithFormat(skipList.head);
    skipList.remove(9);
    skipList.remove(1000);
    printWithFormat(skipList.head);
  }

}