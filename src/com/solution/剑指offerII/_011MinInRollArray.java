package com.solution.剑指offerII;

// https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
// 同样一道题目，这个是easy，另一个是hard，因为这个可以用O(n)时间复杂度
public class _011MinInRollArray {

  /**
   * 不存在相同值
   * 3 4 5 1 2
   * 4 5 1 2 3
   */
  public static int solution1(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = l + (r - l) / 2;

    }
    return nums[r];
  }

  /**
   * 存在相同值的二分查找
   * @return
   */
  public static int solution2(int[] nums) {

    return 0;
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 2, 3, 4, 5};
    int[] nums2 = new int[]{5, 4, 3, 2, 1};
    int[] nums3 = new int[]{3, 4, 5, 1, 2};
    int[] nums4 = new int[]{4, 5, 1, 2, 3};
    System.out.println(solution1(nums1));
    System.out.println(solution1(nums2));
    System.out.println(solution1(nums3));
    System.out.println(solution1(nums4));
  }
}