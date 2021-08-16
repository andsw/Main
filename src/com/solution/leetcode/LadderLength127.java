package com.solution.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LadderLength127 {

  private static int solution(String beginWord, String endWord, List<String> wordList) {
    Queue<String> queue = new LinkedList<>();
    HashMap<String, Integer> map = new HashMap<>();
    for (String item : wordList) {
      if (item.equals(beginWord)) {
        map.put(item, 1);
      } else {
        map.put(item, 0);
      }
    }
    queue.offer(beginWord);
    while (!queue.isEmpty()) {
      String temp = queue.poll();
      for (int i = 0; i < temp.length(); i++) {
        for (int j = 0; j < 26; j++) {
          char c = (char)('a' + j);
          if (c == temp.charAt(i)) {
            continue;
          }
          String tar = temp.substring(0, i) + c + temp.substring(i + 1);
          if (map.containsKey(tar)) {
            if (map.get(tar) == 0) {
              map.put(tar, map.getOrDefault(temp, 1) + 1);
              queue.offer(tar);
            }
          }
        }
      }
    }
    return map.getOrDefault(endWord, 0);
  }

}