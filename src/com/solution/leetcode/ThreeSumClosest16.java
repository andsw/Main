package com.solution.leetcode;

import java.util.Arrays;

public class ThreeSumClosest16 {

  private static int solution(int[] nums, int target) {
    Arrays.sort(nums);
    int res = target;
    for (int i = 1; i < nums.length - 1; i++) {
      int l = 0, r = nums.length - 1;
      while (l < i && r > i) {
        int temp = nums[l] + nums[r] + nums[i];
        if (temp == target) {
          return temp;
        } else if (res == target || Math.abs(temp - target) < Math.abs(res - target)) {
          res = temp;
        }

        if (temp < target) {
          l++;
          while (l < i && nums[l] == nums[l - 1]) {
            l++;
          }
        } else {
          r--;
          while (r > i && nums[r] == nums[r + 1]) {
            r--;
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    // -5 -5 -4 0 0 3 3 4 5
    System.out.println(solution(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    System.out.println(solution(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, 0));
  }
}