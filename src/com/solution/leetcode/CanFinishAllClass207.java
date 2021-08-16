package com.solution.leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CanFinishAllClass207 {

  public static boolean solution1(int numCourses, int[][] pre) {
    int[] visited = new int[numCourses + 1];
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] ii : pre) {
      if (!map.containsKey(ii[0] + 1)) {
        map.put(ii[0] + 1, new ArrayList<>());
      }
      map.get(ii[0] + 1).add(ii[1] + 1);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= numCourses; i++) {
      if (visited[i] != 0) {
        continue;
      }
      queue.offer(i);
      while (!queue.isEmpty()) {
        int temp = queue.poll();
        List<Integer> temps = map.get(temp);
        if (temps != null) {
          for (int t : temps) {
            if (visited[t] == i) {
              return false;
            }
            queue.offer(t);
          }
        }
        visited[temp] = i;
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    System.out.println(solution1(2, new int[][]{}));
//    System.out.println(solution1(2, new int[][]{{1, 0}, {0, 1}}));
//    System.out.println(solution1(2, new int[][]{{1, 0}}));
//    System.out.println(solution1(3, new int[][]{{1, 2}, {2, 0}, {0, 1}}));
//    System.out.println(solution1(3, new int[][]{{1, 2}, {1, 0}, {2, 1}}));
//    System.out.println(solution1(3, new int[][]{{1, 2}, {2, 0}}));
//    System.out.println(solution1(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}}));
    // true false true false false true true
    System.out.println(BigDecimal.valueOf(10).divide(BigDecimal.valueOf(3)));
  }
}