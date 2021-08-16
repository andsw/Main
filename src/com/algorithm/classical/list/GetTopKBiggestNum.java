package com.algorithm.classical.list;

import com.algorithm.util.ArrayUtil;

public class GetTopKBiggestNum {

  /**
   * 快排
   * @param nums
   * @param k
   * @return
   */
  private static int[] solution1(int[] nums, int k) {
    int[] res = new int[k];
    qSort(nums, 0, nums.length, res, 0);
    return res;
  }

  private static void qSort(int[] nums, int s, int e, int[] res, int sIdx) {
    int l = s, r = e - 1;
    int temp = nums[s];
    while (l < r) {
      while (l < e && temp >= nums[l]) {
        l++;
      }
      while (temp < nums[r]) {
        r--;
      }
      if (l < r) {
        ArrayUtil.swap(nums, l, r);
      }
    }
    nums[s] = nums[r];
    nums[r] = temp;
    if (e - r == res.length - sIdx) {
      System.arraycopy(nums, r, res, 0, res.length);
    } else if (e - r < res.length - sIdx) {
      if (e - r >= 0)
        System.arraycopy(nums, r, res, sIdx, e - r);
      qSort(nums, s, r, res, sIdx + e - r);
    } else {
      qSort(nums, r + 1, e, res, sIdx);
    }
  }

  /**
   * 堆
   * @param nums
   * @param k
   */
  private static int[] solution2(int[] nums, int k) {
    int[] res = new int[k];
    System.arraycopy(nums, 0, res, 0, k);
    adjustDump(res);
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > res[0]) {
        res[0] = nums[i];
        adjustDump(res);
      }
    }
    return res;
  }

  private static void adjustDump(int[] dump) {
    int len = dump.length;
    int first = len / 2 - 1;
    int left, right;
    for (int i = first; i >= 0; i--) {
      left = i * 2 + 1;
      right = i * 2 + 2;
      int temp = left;
      if (right < len && dump[right] < dump[left]) {
        temp = right;
      }
      if (dump[i] > dump[temp]) {
        ArrayUtil.swap(dump, i, temp);
      }
    }
  }

  public static void main(String[] args) {
    for (int i : solution1(new int[]{4, 5, 1, 2, 6, 9, 8, 7, 3}, 3)) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : solution1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2)) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : solution1(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 3)) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : solution2(new int[]{4, 5, 1, 2, 6, 9, 8, 7, 3}, 3)) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : solution2(new int[]{2, 1, 3, 4, 5, 6, 7, 8, 9}, 2)) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : solution2(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 3)) {
      System.out.print(i + " ");
    }
  }
}