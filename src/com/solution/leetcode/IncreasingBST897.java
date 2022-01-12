package com.solution.leetcode;

import com.algorithm.constant.TreeNode;
import com.algorithm.util.TreeUtil;

/**
 * BST -> 单项递增树
 *
 */
public class IncreasingBST897 {

  private static TreeNode<Integer> biggest;

  public static TreeNode<Integer> increasingBST(TreeNode<Integer> root) {
    if (root == null) {
      return null;
    }
    TreeNode<Integer> res;
    if (root.left == null) {
      root.right = increasingBST(root.right);
      if (root.right == null) {
        biggest = root;
      }
      res = root;
    } else {
      res = increasingBST(root.left);
      biggest.right = root;
      root.left = null;
      if (root.right == null) {
        biggest = root;
      }
      root.right = increasingBST(root.right);
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode<Integer> root = TreeUtil.generate(
        new Integer[]{2, 0, 3, null, 1, null, 4});
    TreeNode<Integer> res = increasingBST(root);
    while (res != null) {
      System.out.println(res.val);
      res = res.right;
    }
  }

}