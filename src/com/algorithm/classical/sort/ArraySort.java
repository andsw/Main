package com.algorithm.classical.sort;

/**
 * 排序算法心得：心细 + 熟悉原理 无需熟记代码，七大排序手到擒来 以下所有排序均为无查阅手写，从大到小排序
 */
public class ArraySort {

  public static void insertSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int j;
      for (j = 0; j < i; j++) {
        if (array[j] < array[i]) {
          break;
        }
      }
      int temp = array[i];
      for (int k = i; k > j; k--) {
        array[k] = array[k - 1];
      }
      array[j] = temp;
    }
    traverse(array);
  }

  // 希尔排序：缩小增量的插入排序法
  public static void shellSort(int[] array) {
    for (int cnt = array.length >> 1; cnt > 0; cnt >>= 1) {
      for (int i = cnt; i < array.length; i += cnt) {
        int j;
        for (j = 0; j < i; j += cnt) {
          if (array[j] < array[i]) {
            break;
          }
        }
        int temp = array[i];
        for (int k = i; k > j; k -= cnt) {
          array[k] = array[k - cnt];
        }
        array[j] = temp;
      }
    }
    traverse(array);
  }

  public static void selectSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int maxIdx = 0;
      int max = -1;
      for (int j = i; j < array.length; j++) {
        if (array[j] > max) {
          maxIdx = j;
          max = array[j];
        }
      }
      swap(array, i, maxIdx);
    }
    traverse(array);
  }

  // ---- bubble sort ----
  public static void bubbleSort(int[] array) {
    for (int i = array.length; i > 0; i--) {
      for (int j = 0; j < i - 1; j++) {
        if (array[j + 1] > array[j]) {
          swap(array, j + 1, j);
        }
      }
    }
    traverse(array);
  }

  public static void bubbleSortPro(int[] array) {
    for (int i = array.length - 1; i > 0; i--) {
      boolean swapped = false;
      for (int j = 0; j < i; j++) {
        if (array[j] < array[j + 1]) {
          swap(array, j, j + 1);
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
    traverse(array);
  }
  // ----------------------

  // ---- quick sort ----
  public static void quickSort(int[] array) {
    quickSort(array, 0, array.length);
    traverse(array);
  }

  public static void quickSort(int[] array, int si, int ei) {
    if (ei - si < 2) {
      return;
    }
    int mid = findMidAndSwap(array, si, ei);
    quickSort(array, si, mid);
    quickSort(array, mid + 1, ei);
  }

  public static int findMidAndSwap(int[] array, int si, int ei) {
    int temp = array[si];
    int l = si, r = ei - 1;
    while (l < r) {
      while (l <  array.length && array[l] >= temp) {
        l++;
      }
      while (array[r] < temp) {
        r--;
      }
      if (l < r) {
        swap(array, l, r);
      }
    }
    array[si] = array[r];
    array[r] = temp;
    return r;
  }
  // -------------------

  // ---- dump sort ----
  public static void dumpSort(int[] array) {
    int firstNotLeafIdx = array.length / 2 - 1;
    for (int i = firstNotLeafIdx; i >= 0; i--) {
      adjustBigDump(array, i, array.length);
    }
    for (int i = 0; i < array.length; i++) {
      swap(array, 0, array.length - i - 1);
      adjustBigDump(array, 0, array.length - i - 1);
    }
    traverse(array);
  }

  public static void adjustBigDump(int[] array, int idx, int length) {
    int l = idx * 2 + 1, r = idx * 2 + 2;
    int temp;
    while (l < length) {
      if (r >= length) {
        temp = l;
      } else {
        if (array[l] > array[r]) {
          temp = r;
        } else {
          temp = l;
        }
      }
      if (array[temp] < array[idx]) {
        swap(array, idx, temp);
        idx = temp;
      } else {
        break;
      }
      l = temp * 2 + 1;
      r = temp * 2 + 2;
    }
  }
  // ------------------

  //  ---- merge sort ----
  public static void mergeSort(int[] array) {
    int[] res = sort(array, 0, array.length);
    traverse(res);
  }

  public static int[] sort(int[] array, int si, int ei) {
    int[] res = new int[ei - si];
    if (ei - si < 2) {
      res[0] = array[si];
      return res;
    }
    int mid = si + (ei - si) / 2;
    merge(sort(array, si, mid), sort(array, mid, ei), res);
    return res;
  }

  public static void merge(int[] a1, int[] a2, int[] res) {
    int i1 = 0, i2 = 0;
    int i = 0;
    while (i1 < a1.length && i2 < a2.length) {
      if (a1[i1] > a2[i2]) {
        res[i] = a1[i1];
        i1++;
      } else {
        res[i] = a2[i2];
        i2++;
      }
      i++;
    }
    for (; i1 < a1.length; i1++, i++) {
      res[i] = a1[i1];
    }
    for (; i2 < a2.length; i2++, i++) {
      res[i] = a2[i2];
    }
  }
  // -------------------

  public static void main(String[] args) {
    int[] array = new int[]{5, 8, 9, 6, 3, 1, 7, 0, 2, 4};

    mergeSort(array);
    selectSort(array);
    bubbleSort(array);
    bubbleSortPro(array);
    quickSort(array);
    insertSort(array);
    shellSort(array);
    dumpSort(array);
  }

  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void traverse(int[] array) {
    for (int i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}