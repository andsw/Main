package com.solution.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectPerfectTree116 {
  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  // bfs
  public Node solution1(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    Node last = root;
    Node pre = null;
    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      if (pre != null) {
        pre.next = temp;
      }
      pre = temp;
      if (temp.left != null) {
        queue.offer(temp.left);
        if (temp == last && temp.right == null) {
          last = temp.left;
          temp.next = null;
          pre = null;
        }
      }
      if (temp.right != null) {
        queue.offer(temp.right);
        if (temp == last) {
          last = temp.right;
          temp.next = null;
          pre = null;
        }
      }
    }
    return root;
  }

  // 上面解法自己做的，这种分层的层次遍历明显复杂
  // 使用官方方式再来一次BFS
  public Node solution2(Node root) {
    if(root == null) {
      return null;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size && !queue.isEmpty(); i++) {
        Node temp = queue.poll();
        if (i == size - 1) {
          temp.next = null;
        } else {
          temp.next = queue.peek();
        }
        if (temp.left != null) {
          queue.offer(temp.left);
        }
        if(temp.right != null){
          queue.offer(temp.right);
        }
      }
    }
    return root;
  }

  // 这也是用时和内存最有效率的一种方式了。
  public Node solution3(Node root) {
    if (root == null) {
      return null;
    }
    Node temp = root;
    while (temp.left != null) {
      temp.left.next = temp.right;
      Node tt = temp;
      while (tt.next != null) {
        tt.right.next = tt.next.left;
        tt = tt.next;
        tt.left.next = tt.right;
      }
      temp = temp.left;
    }
    return root;
  }
}