package com.algorithm.classical;

import com.algorithm.constant.TreeNode;
import com.algorithm.util.TreeUtil;
import java.util.Stack;

public class TreeTraverse {
  /**
   *   o
   *  o  o
   * o o   o
   */
  private static void frontTraverse(TreeNode<Integer> root) {
    Stack<TreeNode<Integer>> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        System.out.println(root.val);
        stack.push(root);
        root = root.left;
      }
      if (!stack.isEmpty()) {
        root = stack.pop();
        root = root.right;
      }
    }
  }

  private static void midTraverse(TreeNode<Integer> root) {
    Stack<TreeNode<Integer>> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      if (!stack.isEmpty()) {
        root = stack.pop();
        System.out.println(root.val);
        root = root.right;
      }
    }
  }

  private static void backTraverse(TreeNode<Integer> root) {
    TreeNode<Integer> temp = null;
    Stack<TreeNode<Integer>> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.peek();
      if (root.right == null || root.right == temp) {
        System.out.println(root.val);
        temp = root;
        root = null;
        stack.pop();
      } else {
        root = root.right;
      }
    }
  }

  public static void main(String[] args) {
    TreeNode<Integer> root = TreeUtil.generate(new Integer[]{1, 2, 3, 4, 5, 6, 7, null, 8});
    frontTraverse(root);
    System.out.println();
    midTraverse(root);
    System.out.println();
    backTraverse(root);
  }
}