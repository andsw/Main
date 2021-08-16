package com.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SkipList1206 {
  static class SkipList {
    private final Node head;

    private static final int MAX_LEVEL = 12;

    public SkipList() {
      head = new Node(Integer.MIN_VALUE, MAX_LEVEL - 1);
      Node temp = head;
      for (int i = 0; i < MAX_LEVEL - 1; i++) {
        temp.down = new Node(Integer.MIN_VALUE, MAX_LEVEL - 2 - i);
        temp = temp.down;
      }
    }

    public boolean search(int target) {
      Node temp = head;
      while (temp != null) {
        if (temp.val == target) {
          return true;
        } else if (temp.next == null || temp.next.val > target) {
          temp = temp.down;
        }  else {
          temp = temp.next;
        }
      }
      return false;
    }

    public void add(int num) {
      List<Node> list = new ArrayList<>();
      Node temp = head;
      while (temp != null) {
        if (temp.val == num) {
          break;
        } else if (temp.next == null || temp.next.val > num) {
          list.add(temp);
          temp = temp.down;
        } else {
          temp = temp.next;
        }
      }
      if (temp == null) {
        for (int i = 0; i < list.size(); i++) {
          Node prev = list.get(list.size() - 1 - i);
          Node newNode = new Node(num, prev.level);
          Node tt = prev.next;
          prev.next = newNode;
          newNode.next = tt;
        }
      } else {
        while (temp.down != null) {
          temp = temp.down;
        }
        Node newNode = new Node(num, 0);
        newNode.next = temp.next;
        temp.next = newNode;
      }
    }

    public boolean erase(int num) {
      return false;
    }

    private static class Node {
      int val;
      Node next;
      Node down;
      int level;

      public Node(int val, int level) {
        this.val = val;
        this.level = level;
      }
    }

    private static final float LEVEL_RIGHT = 0.5f;

    private int randomLevel() {
      int level = 0;
      while (Math.random() < LEVEL_RIGHT && level < MAX_LEVEL) {
        level++;
      }
      return level;
    }
  }

  public static void main(String[] args) {
    SkipList obj = new SkipList();
    System.out.println(obj.search(11));
    for (int i = 0; i < 20; i++) {
      obj.add(i);
    }
    System.out.println(obj.search(11));
    System.out.println(obj.erase(11));
    System.out.println(obj.search(11));
  }
}