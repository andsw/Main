package com.algorithm.classical.graph;

public class Floyd {

  private static final Integer IMAX = Integer.MAX_VALUE;

  private static void floyd(int[][] graph) {
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[i].length; j++) {
        for (int k = 0; k < graph[j].length; k++) {
          graph[i][k] = Math.min(graph[i][k],
              graph[i][j] + graph[j][k] < 0 ? IMAX : graph[i][j] + graph[j][k]);
        }
      }
    }
    print(graph);
  }

  private static void print(int[][] graph) {
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < i; j++) {
        System.out.println(j + " 距离 " + i + " " + graph[i][j]);
      }
    }
  }

  public static void main(String[] args) {
    int[][] graph = new int[][]{
        {0, 1, 3, 6},
        {1, 0, 1, 6},
        {3, 1, 0, 2},
        {6, 6, 2, 0}
    };
    floyd(graph);
    System.out.println("");
    graph = new int[][]{
        {0, 1, IMAX, IMAX, 5},
        {1, 0, 1, IMAX, IMAX},
        {IMAX, 1, 0, 1, IMAX},
        {IMAX, IMAX, 1, 0, 1},
        {5, IMAX, IMAX, 1, 0}
    };
    floyd(graph);
  }
}