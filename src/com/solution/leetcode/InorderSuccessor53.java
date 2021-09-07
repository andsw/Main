package com.solution.leetcode;

import com.algorithm.constant.TreeNode;
import com.algorithm.util.TreeUtil;
import java.util.Objects;
import java.util.Optional;
import java.util.Stack;

/**
 * 注意：本题与主站 285 题相同： https://leetcode-cn.com/problems/inorder-successor-in-bst/
 */
public class InorderSuccessor53 {
  // 非递归遍历查找，没有充分利用二叉搜索树的特性
  private static TreeNode<Integer> solution1(TreeNode<Integer> root, TreeNode<Integer> p) {
    boolean ok = false;
    Stack<TreeNode<Integer>> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      TreeNode<Integer> node = stack.pop();
      if (ok) {
        return node;
      } else if (Objects.equals(node.val, p.val)) {
        ok = true;
      }
      if (node.right != null) {
        root = node.right;
      }
    }
    return null;
  }

  /**
   * 相比 solution1 的 O(N)，此方法充分利用搜索树的特性把时间复杂度简化成O(logN)
   */
  public static TreeNode<Integer> solution2(TreeNode<Integer> root, TreeNode<Integer> p) {
    if(root == null) {
      return null;
    }
    TreeNode<Integer> res;
    if (p.val < root.val) {
      res = solution2(root.left, p);
      if (res == null) {
        res = root;
      }
    } else {
      if (p.val.equals(root.val)) {
        root = root.right;
        while (root != null && root.left != null) {
          root = root.left;
        }
        res = root;
      } else {
        res = solution2(root.right, p);
      }
    }
    return res;
  }

  public static void main(String[] args) {
//    traverseWithoutRecursion(TreeUtil.generate(new Integer[]{2, 1, 3}));
    TreeNode<Integer> res = solution1(TreeUtil.generate(new Integer[]{2, 1, 3}),
        new TreeNode<>(3));
    System.out.println(Optional.ofNullable(res).orElse(new TreeNode<>()).val);

    TreeNode<Integer> res1 = solution2(
        TreeUtil.generate(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), new TreeNode<>(3));
    System.out.println(res1 == null ? null : res1.val);
  }
}