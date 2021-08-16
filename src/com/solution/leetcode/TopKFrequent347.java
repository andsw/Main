package com.solution.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/ 经典找寻前 k 项最大/小项
 */
public class TopKFrequent347 {

  /**
   * 快排做法
   *
   * @return
   */
  private static int[] solution1(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
      int[] res = new int[k];
      List<Integer[]> list = new ArrayList<>();
      for (Entry<Integer, Integer> e : map.entrySet()) {
        list.add(new Integer[]{e.getKey(), e.getValue()});
      }
      qSort(list, 0, list.size(), res, 0);
      return res;
  }

  public static void qSort(List<Integer[]> nums, int s, int e, int[] res, int sIdx) {
    int l = s, r = e - 1;
    int temp = nums.get(s)[1];
    while (l < r) {
      while (l < r && nums.get(l)[1] <= temp) {
        l++;
      }
      while (nums.get(r)[1] > temp) {
        r--;
      }
      if (l < r) {
        Collections.swap(nums, l, r);
      }
    }
    Collections.swap(nums, s, r);
    if (e - r == res.length - sIdx) {
      for (int i = 0; i < e - r; i++) {
        res[sIdx + i] = nums.get(r + i)[0];
      }
    } else if (e - r < res.length - sIdx) {
      for (int i = 0; i < e - r; i++) {
        res[sIdx + i] = nums.get(r + i)[0];
      }
      qSort(nums, s, r, res, sIdx + e - r);
    } else {
      qSort(nums, r + 1, e, res, sIdx);
    }
  }

  /**
   * 堆排做法
   *
   * @return
   */
  private static int[] solution2(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int i = 0;
    int[][] dump = new int[k][2];
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      if (i < k) {
        dump[i] = new int[]{e.getKey(), e.getValue()};
        if (i == k - 1) {
          adjustDump(dump);
        }
      } else {
        if (e.getValue() > dump[0][1]) {
          dump[0] = new int[]{e.getKey(), e.getValue()};
          adjustDump(dump);
        }
      }
      i++;
    }
    int[] res = new int[k];
    for (int j = dump.length - 1; j >= 0; j--) {
      res[j] = dump[j][0];
    }
    return res;
  }

  private static void adjustDump(int[][] dump) {
    int first = dump.length / 2 - 1;
    int left, right;
    for (int i = first; i >= 0; i--) {
      left = i * 2 + 1;
      right = i * 2 + 2;
      int temp;
      if (right >= dump.length) {
        temp = left;
      } else {
        if (dump[right][1] < dump[left][1]) {
          temp = right;
        } else {
          temp = left;
        }
      }
      if (dump[temp][1] < dump[i][1]) {
        swap(dump, i, temp);
      }
    }
  }

  public static void swap(int[][] nums, int x, int y) {
    int[] temp = nums[x];
    nums[x] = nums[y];
    nums[y] = temp;
  }

  public static void main(String[] args) {
    int[] array1 = new int[]{1, 2, 1, 1, 3, 2};
    int[] array2 = new int[]{1};
    for (int i : solution1(array1, 2)) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : solution1(array2, 1)) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : solution2(array1, 2)) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : solution2(array2, 1)) {
      System.out.print(i + " ");
    }
  }

}