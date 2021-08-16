package com.algorithm.util;

public class ArrayUtil {

  public static void printAfterReplaceBrackets(String st) {
    st = st.replaceAll("\\[", "{");
    st = st.replaceAll("]", "}");
    st = st.replaceAll(",", ", ");
    System.out.println(st);
  }

  public static <T> void traverse(T[] array) {
    for (T t : array) {
      System.out.print(t + " ");
    }
    System.out.println();
  }

  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void main(String[] args) {
    printAfterReplaceBrackets("[[1,2],[3,5],[6,7],[8,10],[12,16]]");
  }

}