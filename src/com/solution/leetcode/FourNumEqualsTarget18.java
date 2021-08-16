package com.solution.leetcode;

import com.algorithm.util.ListUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumEqualsTarget18 {

  private static List<List<Integer>> solution(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int l = j + 1, r = nums.length - 1;
        while (l < r) {
          int tempSum = nums[i] + nums[j] + nums[l] + nums[r];
          if (tempSum == target) {
            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
            l++;
            while (l < r && nums[l] == nums[l - 1]) {
              l++;
            }
            r--;
            while (l < r && nums[r] == nums[r + 1]) {
              r--;
            }
          } else if (tempSum < target) {
            l++;
            while (l < r && nums[l] == nums[l - 1]) {
              l++;
            }
          } else {
            r--;
            while (l < r && nums[r] == nums[r + 1]) {
              r--;
            }
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    ListUtil.traverseList(solution(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    ListUtil.traverseList(solution(new int[]{1, 0, -1, 0, -2, 2}, 0));
  }
}