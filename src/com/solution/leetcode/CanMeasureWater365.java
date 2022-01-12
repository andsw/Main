package com.solution.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CanMeasureWater365 {

  private static Set<Long> set = new HashSet<>();

  /**
   * 每一步6个操作
   * a -> 0 / b -> 0
   * a -> full / b -> full
   * a -> b / b -> a（倒入直至为0）
   */
  public static boolean solution1(int ac, int bc, int zc) {
    if (ac < zc && bc < zc) {
      return false;
    }
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{0, 0});
    while (!stack.isEmpty()) {
      int[] pop = stack.pop();
      if (pop[0] == zc || pop[1] == zc) {
        return true;
      }
      int[] aa;
      aa = new int[]{pop[0], 0};
      if (pop[1] != 0 && !set.contains(longOf(aa))) {
        stack.push(aa);
        set.add(longOf(aa));
      }
      aa = new int[]{0, pop[1]};
      if (pop[0] != 0 && !set.contains(longOf(aa))) {
        stack.push(aa);
        set.add(longOf(aa));
      }
      aa = new int[]{ac, pop[1]};
      if (pop[0] != ac && !set.contains(longOf(aa))) {
        stack.push(aa);
        set.add(longOf(aa));
      }
      aa = new int[]{pop[0], bc};
      if (pop[1] != bc && !set.contains(longOf(aa))) {
        stack.push(aa);
        set.add(longOf(aa));
      }
      aa = new int[]{0, bc - pop[1] > pop[0] ? pop[1] + pop[0] : (pop[0] - ac + pop[0]) % bc};
      if (pop[0] > 0 && !set.contains(longOf(aa))) {
        stack.push(aa);
        set.add(longOf(aa));
      }
      aa = new int[]{ac - pop[0] > pop[1] ? pop[0] + pop[1] : (pop[1] - ac + pop[0]) % ac, 0};
      if (pop[1] > 0 && !set.contains(longOf(aa))) {
        stack.push(aa);
        set.add(longOf(aa));
      }
    }
    return false;
  }

  public static long longOf(int[] item) {
    return item[0] * 10001L + item[1];
  }

  public static void main(String[] args) {
    System.out.println(solution1(1, 2, 3));
    System.out.println(solution1(3, 5, 4));
    System.out.println(solution1(2, 6, 5));
  }
}