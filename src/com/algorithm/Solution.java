package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Map<String, Integer> map = new HashMap<>();
    for (String item : wordList) {
      map.put(item, 2);
    }
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    while (!queue.isEmpty()) {
      String temp = queue.poll();
      for (int i = 0; i < temp.length(); i++) {
        for (int j = 0; j < 26; j++) {
          char tt = (char) ('a' + j);
          String target = temp.substring(0, i) + tt + temp.substring(i + 1);
          if (!beginWord.equals(target) && map.containsKey(target)) {
            if (target.equals(endWord)) {
              return map.get(endWord) + 1;
            } else if (map.get(target) == 2) {
              map.put(target, map.getOrDefault(temp, 1) + 1);
              queue.offer(target);
            }
          }
        }
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(
        ladderLength("a", "c", Arrays.asList("a", "b", "c")));
    System.out.println(
        ladderLength("hot", "dog", Arrays.asList("hit", "dog", "dot")));
  }
}