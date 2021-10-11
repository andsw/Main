package com.solution.剑指offerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class _045JoinArrayGetMin {

  private static String minValue = "";

  /**
   * try dfs + 剪枝
   */
  public static String solution(int[] nums) {

    return null;
  }

  public void dfs(int[] nums) {

  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{10, 2}).equals("102"));
    System.out.println(solution(new int[]{3, 30, 34, 5, 9}).equals("3033459"));
    System.out.println(solution(new int[]{0, 1}).equals("1"));
  }
}