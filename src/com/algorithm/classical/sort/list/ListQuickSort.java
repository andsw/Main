package com.algorithm.classical.sort.list;

import static com.algorithm.util.ListUtil.array2List;
import static com.algorithm.util.ListUtil.swapNodeValue;
import static com.algorithm.util.ListUtil.traverseList;

import com.algorithm.constant.ListNode;

public class ListQuickSort {

  private static void sort(ListNode<Integer> head, ListNode<Integer> tail) {
    if (head != tail) {
      ListNode<Integer> mid = findMidValueNode(head, tail);
      sort(head, mid);
      sort(mid.next, tail);
    }
  }

  private static ListNode<Integer> findMidValueNode(ListNode<Integer> head,
      ListNode<Integer> tail) {
    ListNode<Integer> p = head;
    ListNode<Integer> q = head.next;
    int key = head.value;
    while (q != tail) {
      if (q.value < key) {
        p = p.next;
        swapNodeValue(p, q);
      }
      q = q.next;
    }
    swapNodeValue(head, p);
    return p;
  }

  public static void main(String[] args) {
    ListNode<Integer> head = array2List(new Integer[]{5, 6, 9, 4, 1, 7, 2, 3, 0, 8});
    sort(head, null);
    traverseList(head);
  }
}