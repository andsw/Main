package com.solution.剑指offerII;

import java.util.Stack;

// https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
// 同样一道题目，这个是easy，另一个是hard，因为这个可以用O(n)时间复杂度
public class _011MinInRollArray {

  /**
   * 不存在相同值
   * 1 2 3 4 5
   * 3 4 5 1 2
   * 4 5 1 2 3
   */
  public static int solution1(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] < nums[r]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return nums[r];
  }

  /**
   * 存在相同值的二分查找
   * @return
   */
  public static int solution2(int[] nums) {
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
    int[] nums1 = new int[]{1, 2, 3, 4, 5};
    int[] nums2 = new int[]{5, 1, 2, 3, 4};
    int[] nums3 = new int[]{4, 5, 1, 2, 3};
    int[] nums4 = new int[]{3, 4, 5, 1, 2};
    int[] nums5 = new int[]{5, 4, 3, 2, 1};
    System.out.println(solution1(nums1));
    System.out.println(solution1(nums2));
    System.out.println(solution1(nums3));
    System.out.println(solution1(nums4));
    System.out.println(solution1(nums5));
    System.out.println("-------------------");
    int[] nums11 = new int[]{1, 1, 1, 1, 5, 0};
    int[] nums22 = new int[]{1, 1, 0, 1, 1};
    int[] nums33 = new int[]{0, 2, 3, 4, 0};
    int[] nums44 = new int[]{0, 4, 5, 0, 0};
    int[] nums55 = new int[]{1, 0, 0, 0, 0};
    System.out.println(solution2(nums11));
    System.out.println(solution2(nums22));
    System.out.println(solution2(nums33));
    System.out.println(solution2(nums44));
    System.out.println(solution2(nums55));
  }
}