package com.algorithm.constant;

public class ListNode<T> {
  public T value;
  public ListNode<T> next;

  public ListNode(T value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value + "";
  }

}