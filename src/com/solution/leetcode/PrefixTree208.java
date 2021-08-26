package com.solution.leetcode;

/**
 * 前缀树
 */
public class PrefixTree208 {

  private static class TrieNode {
    TrieNode[] trieNodes;
    boolean isEnd;

    TrieNode() {
      trieNodes = new TrieNode[27];
    }
  }

  private static class Trie {
    TrieNode[] nodes = new TrieNode[28];

    public Trie() {

    }

    public void insert(String word) {
      TrieNode[] temp = nodes;
      for (int i = 0; i < word.length(); i++) {
        int idx = word.charAt(i) - 'a';
        if(temp[idx] == null) {
          temp[idx] = new TrieNode();
        }
        if (i == word.length() - 1) {
          temp[idx].isEnd = true;
        }
        temp = temp[idx].trieNodes;
      }
    }

    public boolean search(String word) {
      TrieNode[] temp = nodes;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        int idx = c - 'a';
        if (temp[idx] == null) {
          return false;
        }
        if (i == word.length() - 1 && temp[idx].isEnd) {
          return true;
        }
        temp = temp[idx].trieNodes;
      }
      return false;
    }

    public boolean startsWith(String prefix) {
      TrieNode[] temp = nodes;
      for (int i = 0; i < prefix.length(); i++) {
        char c = prefix.charAt(i);
        int idx = c - 'a';
        if (temp[idx] == null) {
          return false;
        }
        temp = temp[idx].trieNodes;
      }
      return true;
    }
  }

  /**
   *
   ["Trie","insert","insert","insert","insert","insert","insert","search","search"]
   [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"]]
   * @param args
   */
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("app");
    trie.insert("apple");
    trie.insert("beer");
    trie.insert("add");
    trie.insert("jam");
    trie.insert("rental");
    System.out.println(trie.search("app"));
  }
}