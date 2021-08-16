package com.solution.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 柱状图中最大矩形
 */
public class LargestRectangleArea84 {

  /**
   * 靠积雨水（LeetCode42）的思维惯性，自己解决了这道题
   * @param heights
   * @return
   */
  public static int largestRectangleArea(int[] heights) {
    int ans = -1;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        int pp = heights[stack.pop()];
        int l;
        if (stack.isEmpty()) {
          l = i;
        } else {
          l = i - stack.peek() - 1;
        }
        ans = Math.max(ans, pp * l);
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int pp = heights[stack.pop()];
      int l;
      if (stack.isEmpty()) {
        l = heights.length;
      } else {
        l = heights.length - stack.peek() - 1;
      }
      ans = Math.max(ans, pp * l);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
  }
}