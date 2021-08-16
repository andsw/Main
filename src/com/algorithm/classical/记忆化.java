package com.algorithm.classical;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 非常经典的一个dfs + 记忆化的题目，
 * leetcode 139 单词拆分
 * 判断是否可以将单词拆分为字典表里面包含的短词
 * 比如 ：
 * 拆分对象 "leetcode" 字典表：{"leet", "code"}
 * 很容易想到dfs，但是当拆分单词的长度过长，如 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
 * 拿第一个嵌套为例：长度分别为 1、2、3、4、5这些，后面跟着的a还得嵌套，呈指数增长。
 *
 * 这就涉及到现在才知道的所谓记忆化的概念，再dfs每一层嵌套互不影响的时候，判断当前开始索引，是否曾经被深搜过，直接continue
 * 不用重复深搜，大大减少dfs的递归
 *
 * 这个是dfs里面了解到的除了剪枝外另一个概念！！！
 */
public class 记忆化 {
  static boolean res;

  public static boolean wordBreak(String word, List<String> wordDict) {
    res = false;
    dfs(word, new HashSet<>(wordDict), new HashSet<>(), 0);
    return res;
  }

  public static void dfs(String word, Set<String> dict, Set<Integer> dfsed, int startIdx) {
    if (startIdx == word.length() || res) {
      res = true;
      return;
    }
    for (int i = startIdx + 1; i < word.length() + 1; i++) {
      if (dfsed.contains(i)) {
        continue;
      }
      if (dict.contains(word.substring(startIdx, i))) {
        dfs(word, dict, dfsed, i);
        dfsed.add(i);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    System.out.println(
        wordBreak("catsandogcat", Arrays.asList("cats", "dog", "sand", "and", "cat", "an")));
    System.out.println(wordBreak(
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
        Arrays.asList("a", "aa", "aaa")));
    
  }
}