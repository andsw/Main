package com.solution.leetcode;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class FindDuplicate287 {
  // 三种经典解法

  /**
   * floyd绕圈法 使用快慢指针，看作寻找环的入口
   *
   * @return
   */
  private static int solution1(int[] nums) {
    int s = 0, f = 0;
    do {
      s = nums[s];
      f = nums[f];
      f = nums[f];
    } while (s != f);
    int b = 0;
    while (b != s) {
      b = nums[b];
      s = nums[s];
      if (b == s) {
        return b;
      }
    }
    return 0;
  }

  /**
   * 使用位运算，算出那一位多出了1
   * 然后使用多出的1计算出重复的数字即可
   *    1  3  4  2  2 多少个1
   *位0 1  1  0  0  0  2
   *位1 0  1  0  1  1  3
   *位2 0  0  1  0  0  1
   * 0-2位数分别为 2,3,1
   * 而正常的1,2,3,4位数分别为 2,2,1
   * 多了位1的 1，所以重复的数字二进制位 010，即 -2-
   * @return
   */
  private static int solution2(int[] nums) {
    int ans = 0;
    int n = nums.length - 1;
    for (int i = 0; n > 0; i++, n >>= 1) {
      int num = 0;
      int temp = 1 << i;
      for (int k : nums) {
        if ((k & temp) != 0) {
          num++;
        }
      }
      for (int j = 1; j <= nums.length - 1; j++) {
        if ((j & temp) != 0) {
          num--;
        }
      }
      if (num != 0) {
        ans += 1 << i;
      }
    }
    return ans;
  }

  /**
   * 题目考察重点：二分法
   * 1,3,4,2,2
   * nums : 1 2 3 4
   *  cnt : 1 3 4 5
   * @return
   * 略...
   */
  private static int solution3() {

    return 0;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 3, 4, 2, 2};
    System.out.println(solution1(nums));
    System.out.println(solution2(nums));
  }
}