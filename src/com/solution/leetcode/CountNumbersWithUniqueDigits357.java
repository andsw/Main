package com.solution.leetcode;

public class CountNumbersWithUniqueDigits357 {

  public static int solution1(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 10;
    }
    int res = 1;
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        res *= 9;
      } else{
        res *= 10 - i;
      }
    }
    res += solution1(n - 1);
    return res;
  }

  public static void main(String[] args) {
    System.out.println(solution1(2));
    System.out.println(solution1(3));
  }
}