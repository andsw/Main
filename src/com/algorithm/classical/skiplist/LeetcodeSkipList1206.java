package com.algorithm.classical.skiplist;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeSkipList1206 {
  static class SkipList {

    private final Node head;
    private static final int MAX_HEIGHT = (int)(Math.log(2500) / Math.log(2));

    public SkipList() {
      head = new Node(Integer.MIN_VALUE);
      Node temp = head;
      for (int i = 0; i < MAX_HEIGHT; i++) {
        temp.down = new Node(Integer.MIN_VALUE);
        temp = temp.down;
      }
    }

    public boolean search(int target) {
      Node temp = head;
      while (temp != null) {
        if (temp.next != null && temp.next.value == target) {
          return true;
        } else if (temp.next == null || temp.next.value > target) {
          temp = temp.down;
        } else {
          temp = temp.next;
        }
      }
      return false;
    }

    public void add(int num) {
      List<Node> list = new ArrayList<>();
      Node temp = head;
      while (temp != null) {
        if (temp.next != null && temp.next.value == num) {
          break;
        } else if (temp.next == null || temp.next.value > num) {
          list.add(temp);
          temp = temp.down;
        } else {
          temp = temp.next;
        }
      }
      if (temp == null) {
        int level = randomLevel();
        Node lst = null;
        for (int i = 1; i <= level; i++) {
          Node prev = list.get(list.size() - i);
          Node nw = new Node(num);
          nw.next = prev.next;
          prev.next = nw;
          nw.down = lst;
          lst = nw;
        }
      } else {
        Node up = null;
        temp = temp.next;
        while (temp != null) {
          Node nw = new Node(num);
          nw.next = temp.next;
          temp.next = nw;
          if (up != null) {
            up.down = nw;
          }
          up = nw;
          temp = temp.down;
        }
      }
    }

    private static final float LEVEL_RIGHT = 0.5F;
    private int randomLevel() {
      int level = 1;
      while (Math.random() < LEVEL_RIGHT && level < MAX_HEIGHT) {
        level++;
      }
      return level;
    }

    public boolean erase(int num) {
      Node temp = head;
      boolean res = false;
      while (temp != null) {
        if (temp.next != null && temp.next.value == num) {
          res = true;
          Node nn = temp.next;
          temp.next = temp.next.next;
          nn.next = null;
          temp = temp.down;
        } else if(temp.next == null || temp.next.value > num) {
          temp = temp.down;
        } else {
          temp = temp.next;
        }
      }
      return res;
    }

    private static class Node {
      int value;
      Node next;
      Node down;
      public Node(int value) {
        this.value = value;
      }
    }

    public void print() {
      printWithFormat(this.head);
    }

    private void printWithFormat(SkipList.Node head) {
      if (head == null) {
        return;
      }
      SkipList.Node temp = head;
      while (head != null) {
        System.out.print(head.value + " ");
        head = head.next;
      }
      System.out.println();
      printWithFormat(temp.down);
    }
  }

  public static void main(String[] args) {
    SkipList skiplist = new SkipList();
    for (int i = 1; i < 100; i++) {
      skiplist.add((int)(Math.random() * 10));
    }
    skiplist.print();
    for (int i = 0; i < 100; i++) {
      System.out.println(skiplist.erase((int) (Math.random() * 10)));
    }
    skiplist.print();
  }
}