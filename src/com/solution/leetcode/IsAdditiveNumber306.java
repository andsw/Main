package com.solution.leetcode;

import java.math.BigInteger;

public class IsAdditiveNumber306 {

  boolean res;

  public boolean isAdditiveNumber(String num) {
    res = false;
    BigInteger num1, num2;
    for (int i = 1; i < (num.length() + 1) / 2; i++) {
      for (int j = i + 1; num.length() - j >= Math.max(i, j - i); j++) {
        String num1Str = num.substring(0, i);
        if (have0Prefix(num1Str)) {
          break;
        }
        num1 = new BigInteger(num1Str);
        String num2Str = num.substring(i, j);
        if (have0Prefix(num2Str)) {
          break;
        }
        num2 = new BigInteger(num2Str);
        dfs(num, j, num1.add(num2), num2);
      }
    }
    return res;
  }

  public void dfs(String num, int idx, BigInteger sum, BigInteger num2) {
    if (idx == num.length()) {
      res = true;
    }
    if (res) {
      return;
    }
    for (int i = idx + 1; i <= num.length(); i++) {
      String tempStr = num.substring(idx, i);
      if (have0Prefix(tempStr)) {
        break;
      }
      BigInteger temp = new BigInteger(tempStr);
      if (temp.compareTo(sum) > 0) {
        break;
      } else if (temp.equals(sum)) {
        dfs(num, i, temp.add(num2), temp);
      }
    }
  }

  public boolean have0Prefix(String str) {
    return str.length() > 1 && str.startsWith("0");
  }

  public static void main(String[] args) {
    IsAdditiveNumber306 t = new IsAdditiveNumber306();
    System.out.println(t.isAdditiveNumber("20224"));
    
  }

}