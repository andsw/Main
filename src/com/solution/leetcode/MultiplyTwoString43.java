package com.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MultiplyTwoString43 {

  private static String solution1(String s1, String s2) {
    if ("0".equals(s1) || "0".equals(s2)) {
      return "0";
    }
    if (s1.length() < s2.length()) {
      return solution1(s2, s1);
    }
    List<Integer> res = new ArrayList<>();
    int[] t1 = new int[s1.length()], t2 = new int[s2.length()];
    for (int i = 0; i < s1.length(); i++) {
      t1[t1.length - i - 1] = s1.charAt(i) - '0';
      if (i < s2.length()) {
        t2[t2.length - i - 1] = s2.charAt(i) - '0';
      }
    }
    for (int i = 0; i < s2.length(); i++) {
      int prev = 0;
      for (int j = 0; j < s1.length(); j++) {
        int temp = t1[j] * t2[i] + prev;
        int idx = j + i;
        prev = temp / 10;
        if (idx >= res.size()) {
          res.add(temp % 10);
        } else {
          int ts = (temp % 10) + res.get(idx);
          res.set(idx, ts % 10);
          prev += (ts / 10);
        }
      }
      int idx = s1.length() + i;
      while (prev != 0) {
        if (idx >= res.size()) {
          res.add(prev);
          prev = 0;
        } else {
          int ts = res.get(idx) + prev;
          res.set(idx, ts % 10);
          prev = (ts / 10);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Integer re : res) {
      sb.append(re);
    }
    return sb.reverse().toString();
  }

  // "12193263111263526900"
  public static void main(String[] args) {
    System.out.println(solution1("4", "25"));
  }
}