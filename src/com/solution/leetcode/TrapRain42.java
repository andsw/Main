package com.solution.leetcode;

import java.util.Stack;

public class TrapRain42 {

  /**
   * 单调栈法
   * @param heights
   * @return
   */
  private static int solution1(int[] heights) {
    int ans = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
        int top = stack.pop();
        if (stack.isEmpty()) {
          break;
        }
        ans += (Math.min(heights[i], heights[stack.peek()]) - heights[top]) * (i - stack.peek() - 1);
      }
      stack.push(i);
    }
    return ans;
  }

  /**
   * 双指针法
   * @param heights
   * @return
   */
  private static int solution2(int[] heights) {
    int[] lm = new int[heights.length];
    int[] rm = new int[heights.length];
    int res = 0;
    for (int i = 0; i < heights.length; i++) {
      if (i == 0 || heights[i] > lm[i - 1]) {
        lm[i] = heights[i];
      } else {
        lm[i] = lm[i - 1];
      }
    }
    for (int i = heights.length - 1; i >= 0; i--) {
      if (i == heights.length - 1 || heights[i] > rm[i + 1]) {
        rm[i] = heights[i];
      } else {
        rm[i] = rm[i + 1];
      }
    }
    for (int i = 0; i < heights.length; i++) {
      res += Math.min(rm[i], lm[i]) - heights[i];
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(solution1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); //6
    System.out.println(solution2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); //6
    System.out.println(solution1(new int[]{4, 2, 0, 3, 2, 5})); //9
    System.out.println(solution2(new int[]{4, 2, 0, 3, 2, 5})); //9
  }
}