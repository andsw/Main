package com.solution.leetcode;

import com.algorithm.constant.TreeNode;
import com.algorithm.util.TreeUtil;
import java.util.Stack;

public class RecoverBinarySearchTree99 {

  public static void solution1(TreeNode<Integer> root) {
    Stack<TreeNode<Integer>> stack = new Stack<>();
    TreeNode<Integer> x = null, y = null, pred = null;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (pred != null && root.val < pred.val) {
        y = root;
        if (x == null) {
          x = pred;
        } else {
          break;
        }
      }
      pred = root;
      root = root.right;
    }

    swap(x, y);
  }

  public static void swap(TreeNode<Integer> x, TreeNode<Integer> y) {
    int tmp = x.val;
    x.val = y.val;
    y.val = tmp;
  }

  public static void main(String[] args) {
    TreeNode<Integer> root = TreeUtil.generate(new Integer[]{3, 1, 4, null, null, 2});
    TreeUtil.midTraverse(root);
    solution1(root);
    TreeUtil.midTraverse(root);
  }
}