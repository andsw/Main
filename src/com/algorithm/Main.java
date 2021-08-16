package com.algorithm;

import com.algorithm.constant.TreeNode;
import com.algorithm.util.TreeUtil;
import java.util.LinkedList;
import java.util.Queue;
import org.w3c.dom.Node;

public class Main {

  class Node {
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

  public Node connect(Node root) {
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

  public static void main(String[] args) {
  }
}
