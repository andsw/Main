package com.algorithm.util;

import com.algorithm.constant.ListNode;
import java.util.List;

public class ListUtil {

  public static <T> void swapNodeValue(ListNode<T> n1, ListNode<T> n2) {
    T temp = n1.value;
    n1.value = n2.value;
    n2.value = temp;
  }

  public static <T> int getListSize(ListNode<T> head) {
    int res = 0;
    while (head != null) {
      res++;
      head = head.next;
    }
    return res;
  }

  public static <T> ListNode<T> array2List(T[] t) {
    ListNode<T> root = new ListNode<>(t[0]);
    ListNode<T> temp = root;
    for (int i = 1; i < t.length; i++) {
      root.next = new ListNode<>(t[i]);
      root = root.next;
    }
    return temp;
  }

  public static <T> void traverseList(ListNode<T> root) {
    while (root != null) {
      System.out.print(root.value + " ");
      root = root.next;
    }
    System.out.println();
  }

  public static <T> void traverseList(List<T> list) {
    for (T t : list) {
      if (t instanceof List) {
        ((List<?>) t).forEach(tt -> System.out.print(tt + " "));
        System.out.println();
      } else {
        System.out.print(t + " ");
      }
    }
    System.out.println("-----------------------");
  }
}