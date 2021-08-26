package com.algorithm.classical.graph;

import java.util.Arrays;
import java.util.Stack;

public class Dijkstra {

  private static final Integer IMAX = Integer.MAX_VALUE;

  private static int dijkstra(int[][] graph, int src, int dst) {
    boolean[] visited = new boolean[graph.length];
    for (int i = 0; i < graph[src].length; i++) {
      for (int j = 0; j < graph[i].length; j++) {
        if (!visited[j] && graph[i][j] != IMAX && graph[i][j] + graph[src][i] < graph[src][j]) {
          graph[src][j] = graph[i][j] + graph[src][i];
        }
      }
      visited[i] = true;
    }
    return graph[src][dst];
  }

  //--------------------------------------------------------------------------------------------
  private static int dijkstraWithPath(int[][] graph, int src, int dst) {
    boolean[] visited = new boolean[graph.length];
    int[] path = new int[graph.length];
    Arrays.fill(path, 0);
    for (int i = 0; i < graph[src].length; i++) {
      for (int j = 0; j < graph[i].length; j++) {
        if (!visited[j] && graph[i][j] != IMAX && graph[i][j] + graph[src][i] < graph[src][j]) {
          graph[src][j] = graph[i][j] + graph[src][i];
          path[j] = i;
        }
      }
      visited[i] = true;
    }
    printPath(path, src, dst);
    return graph[src][dst];
  }

  public static void printPath(int[] path, int src, int dst) {
    Stack<Integer> ans = new Stack<>();
    ans.push(dst);
    for (int i = dst; path[i] != -1; i = path[i]) {
      if (i == src) {
        while (!ans.isEmpty()) {
          System.out.print(ans.pop());
          if (!ans.isEmpty()) {
            System.out.print(" -> ");
          }
        }
        System.out.println();
        return;
      }
      ans.push(path[i]);
    }
  }

  public static void main(String[] args) {
    int[][] graph = {
        {0, 1, 3, 6},
        {1, 0, 1, 6},
        {3, 1, 0, 2},
        {6, 6, 2, 0}
    };
    System.out.println(dijkstraWithPath(graph, 0, 1));
    System.out.println(dijkstraWithPath(graph, 0, 2));
    System.out.println(dijkstraWithPath(graph, 0, 3));
    System.out.println(dijkstraWithPath(graph, 1, 3));
    int[][] graph2 = {
        {0, 1, IMAX, IMAX, 5},
        {1, 0, 1, IMAX, IMAX},
        {IMAX, 1, 0, 1, IMAX},
        {IMAX, IMAX, 1, 0, 1},
        {5, IMAX, IMAX, 1, 0}
    };
    System.out.println(dijkstraWithPath(graph2, 0, 4));
  }
}