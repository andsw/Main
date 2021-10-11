package com.solution.leetcode;

public class FindMinInRollArrayII154 {

  private static int solution(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] < nums[r]) {
        r = mid;
      } else if (nums[mid] > nums[r]) {
        l = mid + 1;
      } else {
        r--;
      }
    }
    return nums[r];
  }

  public static void main(String[] args) {

  }
}