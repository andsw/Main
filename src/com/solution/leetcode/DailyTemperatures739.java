package com.solution.leetcode;

import com.algorithm.util.ArrayUtil;
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {

  private static int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        int top = stack.pop();
        res[top] = i - top;
      }
      stack.push(i);
    }
    return res;
  }

  public static void main(String[] args) {
    ArrayUtil.traverse(
        Arrays.stream(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})).boxed()
            .toArray(Integer[]::new));
  }
}