package com.algorithm.classical.sort.list;

import static com.algorithm.util.ListUtil.array2List;
import static com.algorithm.util.ListUtil.traverseList;

import com.algorithm.constant.ListNode;

public class ListMergeSort {

  public static ListNode<Integer> mergeSort(ListNode<Integer> head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode<Integer> mid = findMidNode(head);
    return merge(mergeSort(head), mergeSort(mid));
  }

  public static ListNode<Integer> merge(ListNode<Integer> l1, ListNode<Integer> l2) {
    ListNode<Integer> res;
    if (l1.value > l2.value) {
      res = l1;
      l1 = l1.next;
    } else {
      res = l2;
      l2 = l2.next;
    }
    ListNode<Integer> temp = res;
    while (l1 != null && l2 != null) {
      if (l1.value > l2.value) {
        temp.next = l1;
        l1 = l1.next;
      } else {
        temp.next = l2;
        l2 = l2.next;
      }
      temp = temp.next;
    }
    if (l1 == null) {
      temp.next = l2;
    } else {
      temp.next = l1;
    }
    return res;
  }

  public static ListNode<Integer> findMidNode(ListNode<Integer> head) {
    ListNode<Integer> s = head, f = head;
    while (f.next != null) {
      f = f.next;
      if (f.next != null) {
        f = f.next;
      }
      if (f.next != null) {
        s = s.next;
      }
    }
    ListNode<Integer> res = s.next;
    s.next = null;
    return res;
  }

  public static void main(String[] args) {
    ListNode<Integer> list = array2List(new Integer[]{5, 3, 7, 4, 1, 6, 8, 9, 0, 2});
    ListNode<Integer> res = mergeSort(list);
    traverseList(res);
  }
}