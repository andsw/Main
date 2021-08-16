package com.solution.leetcode;

public class FindMedianSortedArrays4 {

  private static int findNoKNum(int[] nums1, int[] nums2, int k) {
    int idx1 = 0, idx2 = 0;
    while (k > 0) {
      if (idx1 < nums1.length && idx2 < nums2.length) {
        if (nums1[idx1] < nums2[idx2]) {
          idx1++;
        } else {
          idx2++;
        }
      } else {
        if (idx1 < nums1.length) {
          idx1++;
        } else {
          idx2++;
        }
      }
      k--;
    }
    if (idx2 >= nums2.length) {
      return nums1[idx1];
    } else if (idx1 >= nums1.length) {
      return nums2[idx2];
    } else {
      return Math.min(nums2[idx2], nums1[idx1]);
    }
  }

  public static double solution(int[] nums1, int[] nums2) {
    int sumLen = nums1.length + nums2.length;
    if (sumLen % 2 == 1) {
      return findNoKNum(nums1, nums2, sumLen / 2);
    } else {
      return (double) (findNoKNum(nums1, nums2, sumLen / 2)
          + findNoKNum(nums1, nums2, sumLen / 2 - 1)) / 2;
    }
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{1, 3}, new int[]{2, 4}));
    System.out.println(solution(new int[]{1, 3, 4}, new int[]{2, 5}));
    System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6}, new int[]{0}));
    System.out.println(solution(new int[]{1, 3, 5, 7, 8}, new int[]{2, 4, 6, 9}));
    System.out.println(solution(new int[]{0}, new int[]{0}));
  }
}