package com.solution.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class CountOfAtoms726 {

  /**
   * 计算分子方程式中有多少个原子！
   * 原题变种，原题中需要标注哪些原子有多少个
   * @param formula
   * @return
   */
  private static Integer solution1(String formula) {
    int res = 0;
    for (int i = 0; i < formula.length(); ) {
      char c = formula.charAt(i);
      if ('(' == c) {
        int bc = 1;
        int j = i + 1;
        for (; j < formula.length(); j++) {
          if (')' == formula.charAt(j)) {
            bc--;
          }
          if ('(' == formula.charAt(j)) {
            bc++;
          }
          if (bc == 0) {
            break;
          }
        }
        int k = j + 1;
        for (; k < formula.length() && Character.isDigit(formula.charAt(k)); k++);
        int count = k - j > 1 ? Integer.parseInt(formula.substring(j + 1, k)) : 1;
        res += solution1(formula.substring(i + 1, j)) * count;
        i = k;
      } else {
        if (Character.isUpperCase(c)) {
          for (i += 1; i < formula.length() && Character.isLowerCase(formula.charAt(i)); i++);
          int j = i;
          for (; j < formula.length() && Character.isDigit(formula.charAt(j)); j++);
          res += j == i ? 1 : Integer.parseInt(formula.substring(i, j));
          i = j;
        }
      }
    }
    return res;
  }

  private static String solution2(String formula) {
    Map<String, Integer> map = new TreeMap<>();
    cal(formula, map, 1);
    StringBuilder res = new StringBuilder();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      res.append(entry.getKey()).append(entry.getValue() == 1 ? "" : entry.getValue());
    }
    return res.toString();
  }

  public static void cal(String formula, Map<String, Integer> map, int count) {
    for (int i = 0; i < formula.length(); ) {
      char c = formula.charAt(i);
      if ('(' == c) {
        int bc = 1;
        int j = i + 1;
        for (; j < formula.length(); j++) {
          if (')' == formula.charAt(j)) {
            bc--;
          }
          if ('(' == formula.charAt(j)) {
            bc++;
          }
          if (bc == 0) {
            break;
          }
        }
        int k = j + 1;
        for (; k < formula.length() && Character.isDigit(formula.charAt(k)); k++);
        int value = k - j > 1 ? Integer.parseInt(formula.substring(j + 1, k)) : 1;
        cal(formula.substring(i + 1, j), map, value * count);
        i = k;
      } else {
        if (Character.isUpperCase(c)) {
          int start = i;
          for (i += 1; i < formula.length() && Character.isLowerCase(formula.charAt(i)); i++);
          int j = i;
          for (; j < formula.length() && Character.isDigit(formula.charAt(j)); j++);
          String key = formula.substring(start, i);
          map.put(key, map.getOrDefault(key, 0) + (j == i ? count
              : Integer.parseInt(formula.substring(i, j)) * count));
          i = j;
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(solution2("H2O"));
    System.out.println(solution2("Mg(OH)2"));
    System.out.println(solution2("SO3"));
    System.out.println(solution2("K4(ON(SO3)2)2"));
    System.out.println(solution2("Be32"));
    System.out.println(solution2("(H)"));
    System.out.println(solution2("(H)2"));
  }
}