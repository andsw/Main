package com.solution.leetcode;

import com.algorithm.constant.ListNode;
import com.algorithm.util.ListUtil;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 很诡异的难题
 */
public class MergeKLists23 {

  private static ListNode<Integer> mergeTwoList(ListNode<Integer> node1, ListNode<Integer> node2) {
    ListNode<Integer> res;
    if (node1.value > node2.value) {
      res = node2;
      node2 = node2.next;
    } else {
      res = node1;
      node1 = node1.next;
    }
    ListNode<Integer> temp = res;
    while (node1 != null && node2 != null) {
      if (node1.value < node2.value) {
        temp.next = node1;
        node1 = node1.next;
      } else {
        temp.next = node2;
        node2 = node2.next;
      }
      temp = temp.next;
    }
    if (node1 == null) {
      temp.next = node2;
    } else {
      temp.next = node1;
    }
    return res;
  }

  /**
   * 使用一个res承接，循环合并
   * @param heads
   * @return
   */
  private static ListNode<Integer> solution1(ListNode<Integer>... heads) {
    ListNode<Integer> res = heads[0];
    for (int i = 1; i < heads.length; i++) {
      if (heads[i] != null) {
        res = mergeTwoList(res, heads[i]);
      }
    }
    return res;
  }

  /**
   * 每两个链表一组合并
   * @param nodes
   * @return
   */
  private static ListNode<Integer> solution2(ListNode<Integer>... nodes) {
    for (int i = 0; (1 << i) < nodes.length; i++) {
      int ii = (1 << i);
      for (int j = 0; j < nodes.length; j += ii + ii) {
        int next = j + ii;
        if (next < nodes.length) {
          nodes[j] = mergeTwoList(nodes[j], nodes[next]);
        }
      }
    }
    return nodes[0];
  }

  /**
   * 优先队列
   * @param nodes
   * @return
   */
  private static ListNode<Integer> solution3(ListNode<Integer>... nodes) {
      ListNode<Integer> res = null;
      ListNode<Integer> temp = null;
    PriorityQueue<ListNode<Integer>> queue = new PriorityQueue<>(nodes.length,
        Comparator.comparing(l -> l.value));
    for (int i = 0; i < nodes.length; i++) {
      queue.offer(nodes[i]);
    }
    while (!queue.isEmpty()) {
      if (temp == null) {
        temp = queue.poll();
        res = temp;
      } else {
        temp.next = queue.poll();
        temp = temp.next;
      }
      if (temp.next != null) {
        queue.offer(temp.next);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    ListUtil.traverseList(solution1(ListUtil.array2List(new Integer[]{1, 4, 5}),
        ListUtil.array2List(new Integer[]{1, 3, 4}), ListUtil.array2List(new Integer[]{2, 6})));
    ListUtil.traverseList(solution2(ListUtil.array2List(new Integer[]{1, 4, 5}),
        ListUtil.array2List(new Integer[]{1, 3, 4}), ListUtil.array2List(new Integer[]{2, 6})));
    ListUtil.traverseList(solution3(ListUtil.array2List(new Integer[]{1, 4, 5}),
        ListUtil.array2List(new Integer[]{1, 3, 4}), ListUtil.array2List(new Integer[]{2, 6})));
  }
}