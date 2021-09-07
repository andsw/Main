package com.solution.剑指offerII;

public class _001DivideTwoNum {

  public static int divide(int a, int b) {
    int res = 0;
    boolean flag = a != Math.abs(a) || b != Math.abs(b);
    a = Math.abs(a);
    b = Math.abs(b);
    while (a >= b) {
      a = a - b;
      res++;
    }
    return flag ? -res : res;
  }

  public static void main(String[] args) {
    System.out.println(divide(7, 4));

  }
}