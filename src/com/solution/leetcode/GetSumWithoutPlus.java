package com.solution.leetcode;

public class GetSumWithoutPlus {

  /**
   * 按位 与 得出进位 1 & 1 = 1
   * 按位 异或 得出进位后当前值 1 ^ 0 = 1   1 ^ 1/0 ^ 0 = 0
   * 按自己的方法实现试试
   * @param a
   * @param b
   * @return
   */
  public static int solution1(int a, int b) {
    String as = Integer.toBinaryString(a);
    String bs = Integer.toBinaryString(b);

    return 0;
  }

  public static int xor(char a, char b) {
    return a == b ? 0 : 1;
  }

  public static int and(char a, char b) {
    return a == 1 && b == 1 ? 1 : 0;
  }

  public static void main(String[] args) {
    System.out.println(10 ^ -7);
    System.out.println("0000000000000000000000000000" + Integer.toBinaryString(10));
    System.out.println(Integer.toBinaryString(-7));

  }
}