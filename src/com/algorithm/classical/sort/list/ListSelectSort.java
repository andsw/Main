package com.algorithm.classical.sort.list;

import static com.algorithm.util.ListUtil.array2List;
import static com.algorithm.util.ListUtil.traverseList;

import com.algorithm.constant.ListNode;

/**
 *
 */
public class ListSelectSort {

  /**
   * 没写出来，觉得也没必要，运用链表自带的属性，插入排序就足够方便。没必要用选择排序。
   * 弃了
   */
  private static ListNode<Integer> sort(ListNode<Integer> head) {
    return null;
  }

  public static void main(String[] args) {
    ListNode<Integer> head = array2List(new Integer[]{5, 6, 3, 4, 7, 9, 1, 2, 8, 0});
    head = sort(head);
    traverseList(head);
  }
}