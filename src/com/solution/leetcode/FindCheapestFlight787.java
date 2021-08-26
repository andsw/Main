package com.solution.leetcode;

// TODO: unsolved
public class FindCheapestFlight787 {
  private static int res;
  private static boolean[] visited;

  /**
   * 虽然加上了剪枝，但还是超时
   * 所以需要考虑使用记忆化的方式。（solution2）
   * 记录每个点到目的地的最近距离和相应的点数。
   */
  private static int solution1(int n, int[][] flights, int src, int dst, int k) {
    res = Integer.MAX_VALUE;
    visited = new boolean[n];
    dfs1(flights, src, dst, k, 0);
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  private static void dfs1(int[][] flights, int src, int dst, int k, int price) {
    if ((k < 0 && src != dst) || price >= res) {
      return;
    }
    if (src == dst) {
      res = price;
      return;
    }
    for (int[] flight : flights) {
      if (flight[0] == src && !visited[flight[1]]) {
        visited[flight[1]] = true;
        dfs1(flights, flight[1], dst, k - 1, price + flight[2]);
        visited[flight[1]] = false;
      }
    }
  }

  //--------------------------------------------------------------------------------------

  /**
   * 动态规划
   */
  private static int solution2(int n, int[][] flights, int src, int dst, int k) {
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(solution2(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
        0, 2, 0));
  }
}