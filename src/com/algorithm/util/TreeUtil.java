package com.algorithm.util;

import com.algorithm.constant.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeUtil {

  /**
   * 生成树
   *
   * @param val
   * @param <T>
   * @return
   */
  public static <T> TreeNode<T> generate(T[] val) {
    if (val.length == 0) {
      return null;
    }
    Queue<TreeNode<T>> queue = new LinkedList<>();
    TreeNode<T> root = new TreeNode<>(val[0]);
    queue.add(root);
    for (int i = 1; i < val.length && !queue.isEmpty(); i++) {
      TreeNode<T> temp = queue.poll();
      if (val[i] != null) {
        temp.left = new TreeNode<>(val[i]);
        queue.add(temp.left);
      }
      if (++i < val.length && val[i] != null) {
        temp.right = new TreeNode<>(val[i]);
        queue.add(temp.right);
      }
    }
    return root;
  }

  /**
   * 前面generate方法将数组转换为二叉树，这里将二叉树转换为数组。
   * @param root
   * @param <T>
   */
  public static <T> void deGenerate(TreeNode<T> root) {
    Queue<TreeNode<T>> queue = new LinkedList<>();
    List<T> res = new ArrayList<>();
    final TreeNode<T> nullNode =new TreeNode<>();
    queue.add(root);
    int num = 0;
    while (!queue.isEmpty()) {
      TreeNode<T> cur = queue.poll();
      if (cur == nullNode) {
        num++;
        res.add(null);
      } else {
        num = 0;
        res.add(cur.val);
        if (cur.left != null) {
          queue.add(cur.left);
        } else {
          queue.add(nullNode);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        } else {
          queue.add(nullNode);
        }
      }
    }
    res = res.subList(0, res.size() - num);
    for (T re : res) {
      System.out.print(re + " | ");
    }
  }

  /**
   * 二叉树 -> 单链表
   *
   * @param root
   */
  public static void flatten(TreeNode<Integer> root) {
    if (root == null) {
      return;
    }
    flatten(root.left);
    flatten(root.right);
    TreeNode<Integer> tmp = root.right;
    root.right = root.left;
    root.left = null;
    while (root.right != null) {
      root = root.right;
    }
    root.right = tmp;
  }

  /**
   * 前序遍历（非递归）
   *
   * @param root
   * @param <T>
   */
  public static <T> void frontTraverse(TreeNode<T> root) {
    Stack<TreeNode<T>> stack = new Stack<>();
    TreeNode<T> cur = root;
    while (cur != null || !stack.empty()) {
      while (cur != null) {
        stack.push(cur);
        System.out.println(cur.val);
        cur = cur.left;
      }
      cur = stack.pop();
      cur = cur.right;
    }
  }

  /**
   * 又一次没写出来，逻辑性还是欠火候啊！
   *
   * @param root
   * @param <T>
   */
  public static <T> void midTraverse(TreeNode<T> root) {
    Stack<TreeNode<T>> stack = new Stack<>();
    TreeNode<T> cur = root;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      System.out.print(cur.val + " ");
      cur = cur.right;
    }
    System.out.println();
  }

  public static <T> void backTraverse(TreeNode<T> root) {
    Stack<TreeNode<T>> stack = new Stack<>();
    TreeNode<T> cur = root;
    TreeNode<T> last = null;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.peek();
      if (cur.right == null || cur.right == last) {
        System.out.println(cur.val);
        last = cur;
        cur = null;
        stack.pop();
      } else {
        cur = cur.right;
      }
    }
  }
}










