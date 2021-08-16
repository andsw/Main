package com.solution.leetcode;

import com.algorithm.util.ArrayUtil;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII503 {
  public static int[] nextGreaterElements(int[] nums) {
    int[] res = new int[nums.length];
    Arrays.fill(res, -1);
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < nums.length * 2 - 1; i++) {
      int idx = i % nums.length;
      while (!stack.isEmpty() && nums[stack.peek() % nums.length] < nums[idx]){
        int top = stack.pop();
        if (top < nums.length) {
          res[top] = nums[idx];
        }
      }
      stack.push(i);
    }
    return res;
  }

  public static void main(String[] args) {
    ArrayUtil.traverse(
        Arrays.stream(nextGreaterElements(new int[]{1, 2, 1})).boxed().toArray(Integer[]::new));

  }
}