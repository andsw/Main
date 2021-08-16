package com.solution.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 包含重复元素数组的全排列
 */
public class PermuteUnique47 {

  /**
   *  先排序，得到全排列的过程中去重
   * @return
   */
  private static List<List<Integer>> res = new ArrayList<>();
  private static List<List<Integer>> solution1(int[] nums) {
    res.clear();
    boolean[] visit = new boolean[nums.length];
    Arrays.sort(nums);
    List<Integer> temp = new ArrayList<Integer>();
    traceBack(nums, temp, visit);
    return res;
  }

  private static void traceBack(int[] nums, List<Integer> tempRes, boolean[] visit) {
      if (tempRes.size() == nums.length) {
        res.add(new ArrayList<>(tempRes));
        return;
      }
      for (int i = 0; i < nums.length; i++) {
        if ((i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]) || visit[i]) {
          continue;
        }
        visit[i] = true;
        tempRes.add(nums[i]);
        traceBack(nums, tempRes, visit);
        tempRes.remove(tempRes.size() - 1);
        visit[i] = false;
      }
  }

  /**
   * 得到所有全排序结果，并对其去重
   * @return
   */
  private static List<List<Integer>> solution2(int[] nums) {

    return null;
  }

  public static void main(String[] args) {
//    List<List<Integer>> lists = solution1(new int[]{1, 1, 2});
//    for (List<Integer> list : lists) {
//      for (Integer integer : list) {
//        System.out.print(integer + " ");
//      }
//      System.out.println();
//    }
//    System.out.println("----");
    List<List<Integer>> lists1 = solution1(new int[]{1, 2, 3});
    for (List<Integer> list : lists1) {
      for (Integer integer : list) {
        System.out.print(integer + " ");
      }
      System.out.println();
    }
  }
}