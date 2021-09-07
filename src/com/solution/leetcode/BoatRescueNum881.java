package com.solution.leetcode;

import java.util.Arrays;

public class BoatRescueNum881 {

  /**
   * 本以为是个背包问题
   * 但只是个简单的贪心
   */
  public static int solution(int[] people, int limit) {
    if (people.length < 2) {
      return people.length;
    }
    int res = 0;
    int l = 0, r = people.length - 1;
    Arrays.sort(people);
    while (l < r) {
      if (people[r] + people[l] > limit) {
        r--;
      } else {
        r--;
        l++;
      }
      res++;
    }
    return l == r ? res + 1 : res;
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{1, 2}, 3));
    System.out.println(solution(new int[]{3, 2, 2, 1}, 3));
    System.out.println(solution(new int[]{3, 5, 3, 4}, 5));
  }
}