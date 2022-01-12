package com.solution.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class NthUglyNums264 {

  public static int solution1(int n) {
    List<Integer> uglyNums = new ArrayList<>();
    uglyNums.add(1);
    int p2 = 0, p3 = 0, p5 = 0;
    int min = 1;
    for (int i = 1; i < n; i++) {
      min = minUgly(uglyNums.get(p2) * 2L, uglyNums.get(p3) * 3L, uglyNums.get(p5) * 5L);
      uglyNums.add(min);
      if (uglyNums.get(p2) * 2L == min) {
        p2++;
      }
      if (uglyNums.get(p3) * 3L == min) {
        p3++;
      }
      if (uglyNums.get(p5) * 5L == min) {
        p5++;
      }
    }
    return min;
  }

  private static int minUgly(long p2, long p3, long p5) {
    return (int) (p2 > p3 ? Math.min(p3, p5) : Math.min(p2, p5));
  }

  private static int[] ys = {5, 3, 2};

  public static int solution2(int n) {
    PriorityQueue<Long> queue = new PriorityQueue<>();
    Set<Long> set = new HashSet<>();
    queue.add(1L);
    set.add(1L);
    long ugly = 1;
    for (int i = 0; i < n; i++) {
      ugly = queue.poll();
      for (int j = 0; j < ys.length; j++) {
        long temp = ugly * ys[j];
        if (!set.contains(temp)) {
          queue.offer(temp);
          set.add(temp);
        }
      }
    }
    return (int)ugly;
  }

  public static void main(String[] args) {
    System.out.println(solution1(10));
    System.out.println(solution1(1690));
  }
}