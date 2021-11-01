package com.solution.leetcode;

import java.util.PriorityQueue;

public class EatenMaxApples1705 {

  /**
   * 吃腐烂时间最早的苹果。
   * @param apples
   * @param days
   * @return
   */
  public static int eatenApples(int[] apples, int[] days) {
    int res = 0;
    PriorityQueue<int[]> queue = new PriorityQueue<>(
        (o1, o2) -> {
          if (o1[0] == o2[0]) {
            return 0;
          }
          return o1[0] > o2[0] ? 1 : -1;
        });
    for (int i = 0; i < apples.length || !queue.isEmpty(); i++) {
      if (i < apples.length && apples[i] > 0) {
        queue.add(new int[]{days[i] + i, apples[i]});
      }
      while (!queue.isEmpty()) {
        int[] earliest = queue.poll();
        if (earliest != null && earliest[0] > i) {
          if (earliest[1] > 0) {
            queue.add(new int[]{earliest[0], earliest[1] - 1});
            res++;
            break;
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
    System.out.println(eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
    System.out.println(eatenApples(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
        new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
  }
}