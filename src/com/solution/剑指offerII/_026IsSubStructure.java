package com.solution.剑指offerII;

import com.algorithm.constant.TreeNode;
import com.algorithm.util.TreeUtil;
import java.util.Objects;

public class _026IsSubStructure {

  /*
   * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/submissions/
   * 差不多写出来了
   * */
  public static boolean solution(TreeNode<Integer> a, TreeNode<Integer> b) {
    return (a != null && b != null) && (recur(a, b) || recur(a.left, b) || recur(a.right, b));
  }

  public static boolean recur(TreeNode<Integer> a, TreeNode<Integer> b) {
    if (b == null) {
      return true;
    }
    if (a == null || !Objects.equals(a.val, b.val)) {
      return false;
    }
    return recur(a.left, b.left) && recur(a.right, b.right);
  }

  public static void main(String[] args) {
    TreeNode<Integer> a = TreeUtil.generate(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    TreeNode<Integer> b = TreeUtil.generate(new Integer[]{1, null, 3, null, null, 6});
    System.out.println(solution(a, b));
  }
}