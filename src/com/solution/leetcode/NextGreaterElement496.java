package com.solution.leetcode;

import com.algorithm.util.ArrayUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement496 {
  private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < nums2.length; i++) {
      while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
        int top = nums2[stack.pop()];
        map.put(top, nums2[i]);
      }
      stack.push(i);
    }
    int[] res = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      res[i] = map.getOrDefault(nums1[i], -1);
    }
    return res;
  }

  public static void main(String[] args) {
    ArrayUtil.traverse(
        Arrays.stream(nextGreaterElement(new int[]{2, 4}, new int[]{1, 3, 4, 2})).boxed()
            .toArray(Integer[]::new));
    ArrayUtil.traverse(
        Arrays.stream(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})).boxed()
            .toArray(Integer[]::new));
  }
}