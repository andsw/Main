package com.algorithm.classical.sort.list;

import static com.algorithm.util.ListUtil.array2List;
import static com.algorithm.util.ListUtil.traverseList;

import com.algorithm.constant.ListNode;

public class ListInsertSort {

  /**
   * @param head
   * @return
   */
  private static ListNode<Integer> sort(ListNode<Integer> head) {
    ListNode<Integer> res = head;
    ListNode<Integer> pre = null;
    while (head.next != null) {
      ListNode<Integer> biggest = findBiggestNode(head);
      if (biggest != head) {
        biggest.next = head;
        if (pre != null) {
          pre.next = biggest;
        } else {
          res = biggest;
        }
        pre = biggest;
      } else {
        pre = head;
        head = head.next;
      }
    }
    return res;
  }

  /**
   * find node with biggest value and fetch it out!
   * @param rest
   * @return
   */
  private static ListNode<Integer> findBiggestNode(ListNode<Integer> rest) {
    ListNode<Integer> res = rest;
    ListNode<Integer> pre = null;
    ListNode<Integer> preRes = null;
    while (rest != null) {
      if (res.value < rest.value) {
        preRes = pre;
        res = rest;
      }
      pre = rest;
      rest = rest.next;
    }
    if (preRes != null) {
      preRes.next = res.next;
      res.next = null;
    }
    return res;
  }

  public static void main(String[] args) {
    ListNode<Integer> head = array2List(new Integer[]{5, 6, 3, 4, 7, 9, 1, 2, 8, 0});
    head = sort(head);
    traverseList(head);
  }
}