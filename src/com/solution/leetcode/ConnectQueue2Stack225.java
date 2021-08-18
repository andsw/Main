package com.solution.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectQueue2Stack225 {
  static class MyStack {

    Queue<Integer> in;
    Queue<Integer> out;

    /** Initialize your data structure here. */
    public MyStack() {
      in = new LinkedList<>();
      out = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
      if (!in.isEmpty()) {
        out.offer(x);
        out.addAll(in);
        in.clear();
      } else {
        in.offer(x);
        in.addAll(out);
        out.clear();
      }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      if (out.isEmpty()) {
        return in.poll();
      } else {
        return out.poll();
      }
    }

    /** Get the top element. */
    public int top() {
      if (out.isEmpty()) {
        return in.peek();
      } else {
        return out.peek();
      }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return out.size() + in.size() == 0;
    }
  }

  public static void main(String[] args) {
    MyStack queue = new MyStack();
    queue.push(1);
    queue.push(2);
    System.out.println(queue.pop());
    queue.push(3);
    System.out.println(queue.pop());
  }
}