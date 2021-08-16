package com.algorithm.classical.list;

import static com.algorithm.util.ListUtil.array2List;
import static com.algorithm.util.ListUtil.traverseList;

import com.algorithm.constant.ListNode;

/**
 * 经典：链表反转
 */
public class ListReverse {

  private static ListNode<Integer> reverse(ListNode<Integer> head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode<Integer> res = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return res;
  }

  public static void main(String[] args) {
    ListNode<Integer> head = array2List(new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
    ListNode<Integer> res = reverse(head);
    traverseList(res);
  }
}