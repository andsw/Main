package com.solution.leetcode;

public class GuessAndPay375 {

  public static int[][] charge;

  public static int solution1(int n) {
    charge = new int[n + 1][n + 1];
    return dfs(1, n);
  }

  public static int dfs(int s, int n) {
    if (n <= s) {
      return 0;
    }
    if (charge[s][n] != 0) {
      return charge[s][n];
    }
    int min = Integer.MAX_VALUE;
    for (int i = s; i <= n; i++) {
      min = Integer.min(min, i + Integer.max(dfs(s, i - 1), dfs(i + 1, n)));
    }
    charge[s][n] = min;
    return min;
  }

  public static void main(String[] args) {
    System.out.println(solution1(200));
  }
}