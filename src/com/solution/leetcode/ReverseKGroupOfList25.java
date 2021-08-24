package com.solution.leetcode;

import com.algorithm.constant.ListNode;
import com.algorithm.util.ListUtil;

/**
 * 这应该是第一个自己解决的hard题目吧！
 * 翻转链表中每k个元素
 */
public class ReverseKGroupOfList25 {

  private static ListNode<Integer> reverseKItems(ListNode<Integer> head, int k) {
    if (k == 1) {
      return head;
    }
    ListNode<Integer> res = reverseKItems(head.next, k - 1);
    head.next.next = head;
    head.next = null;
    return res;
  }

  /**
   * 自己想的方法一
   *
   * @param head
   * @param k
   * @return
   */
  private static ListNode<Integer> solution1(ListNode<Integer> head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode<Integer> prev = null, temp = head;
    ListNode<Integer> res = null;
    int len = 0;
    while (head != null || len == k) {
      if (len == k) {
        if (res == null && prev == null) {
          res = reverseKItems(temp, k);
        } else {
          prev.next = reverseKItems(temp, k);
        }
        prev = temp;
        len = 0;
        temp = head;
        continue;
      }
      len++;
      head = head.next;
    }
    if (len > 0) {
      if (res == null) {
        res = temp;
      } else {
        prev.next = temp;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    ListNode<Integer> head = ListUtil.array2List(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    ListNode<Integer> head2 = ListUtil.array2List(new Integer[]{1, 2, 3, 4, 5, 6});
    ListNode<Integer> head3 = ListUtil.array2List(new Integer[]{1});
    ListNode<Integer> head4 = ListUtil.array2List(new Integer[]{1, 2});
    ListNode<Integer> head5 = ListUtil.array2List(new Integer[]{1, 2, 3});
    int k = 1;
    ListUtil.traverseList(solution1(head, k));
    ListUtil.traverseList(solution1(head2, k));
    ListUtil.traverseList(solution1(head3, k));
    ListUtil.traverseList(solution1(head4, k));
    ListUtil.traverseList(solution1(head5, k));
  }
}