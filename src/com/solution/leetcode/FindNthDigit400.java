package com.solution.leetcode;

/**
 * 实在做不出来，脑子太笨了。这么简单的题目代码实现不了。。。
 */
public class FindNthDigit400 {

  private static int solution1(int n) {
    long start = 1;
    long num = 9;
    int temp = n;
    for (int i = 1; i < 10; i++) {
      if (temp <= num) {
        long tar = start + (temp - 1) / i;
        int no = (temp - 1) % i;
        return getNthCharInNum(tar, no, i);
      }
      temp = (int) (temp - num);
      num = num * 10 * i;
      start *= 10;
    }
    return 0;
  }

  private static int getNthCharInNum(long num, int n, int len) {
    for (int i = 0; i < len - 1 - n; i++) {
      num /= 10;
    }
    return (int) (num % 10);
  }

  public static void main(String[] args) {
//    System.out.println(solution1(3));
//    System.out.println(solution1(10));
//    System.out.println(solution1(11));
//    System.out.println(solution1(189));
//    System.out.println(solution1(190));
//    System.out.println(solution1(214748364));

  }

}