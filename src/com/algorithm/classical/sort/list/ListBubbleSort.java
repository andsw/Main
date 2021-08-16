package com.algorithm.classical.sort.list;

import static com.algorithm.util.ListUtil.getListSize;

import com.algorithm.constant.ListNode;
import com.algorithm.util.ListUtil;

/**
 * 原来所谓的链表冒泡排序，
 * 就是指将节点的值更换而不是节点的顺序。。。至少我在网上看到的是这样
 * 我一直在死磕更换节点顺序，终于被我磕出来了。
 * 让我再写一次不一定写得出来。但交换值的可以！
 */
public class ListBubbleSort {

  private static ListNode<Integer> sort(ListNode<Integer> head) {
    int size = getListSize(head);
    for (int i = 0; i < size; i++) {
      head = singleBubble(head);
    }
    return head;
  }

  public static ListNode<Integer> singleBubble(ListNode<Integer> head) {
    ListNode<Integer> res = head;
    ListNode<Integer> pre = null;
    while (head.next != null) {
      if (head.next.value > head.value) {
        ListNode<Integer> temp = head.next;
        head.next = temp.next;
        temp.next = head;
        if (pre != null) {
          pre.next = temp;
        } else {
          res = temp;
        }
        pre = temp;
      } else {
        pre = head;
        head = head.next;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    ListNode<Integer> head = ListUtil
        .array2List(new Integer[]{5, 8, 6, 1, 3, 4, 7, 9, 0, 2});
    head = sort(head);
    ListUtil.traverseList(head);
  }
}