package com.algorithm.classical.search;

public class BinarySearch {

  private static int search(int[] array, int target) {
    int l = 0, r = array.length - 1;
    while (l < r) {
      int mid = l + (r - l) / 2 + 1;
      if (target < array[mid]) {
        r = mid - 1;
      } else if (target > array[mid]) {
        l = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  /**
   * 寻找小于或等于target的最大值 索引位置
   * 两个要点：
   * - 找上届时 target < array[mid] r = mid留住mid项（找下界同理）
   * - mid向上取，否则当l = r - 1时，array[mid] < target会陷入死循环
   */
  private static int search4LowBound(int[] array, int target) {
    int l = 0, r = array.length;
    while (l < r) {
      int mid = l + (r - l) / 2 + 1;
      if (mid < array.length && target <= array[mid]) {
        r = mid - 1;
      } else {
        l = mid;
      }
    }
    return l;
  }

  public static int search4HighBound(int[] array, int target) {
    int l = 0;
    int r = array.length;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (target >= array[mid]) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    return r;
  }

  /**
   * what if there are multiple items with value == target
   * and I want to know how many items with value == target
   */
  public static int search4BothBound(int[] array, int target) {
    int r = search4HighBound(array, target);
    int l = search4LowBound(array, target);
    // high bound
    return r - l - 1;
  }

  /**
   * roll array: 1, 2, 3, 4, 5 -> 4, 5, 1, 2, 3
   * @return
   */
  private static int searchInRollArray(int[] array, int target) {
    int l = 0, r = array.length;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (target < array[mid]) {
        if (target < array[l]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      } else if (target > array[mid]) {
        if (target > array[r - 1]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] array0 = new int[]{1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 60, 3};
    System.out.println(search(array0, 3));
    System.out.println(search(array0, 13));
    int[] array1 = new int[]{1, 3, 6, 9, 10, 13, 16, 22, 31, 48, 49, 55};
    System.out.println(search4LowBound(array1, 2));
    System.out.println(search4HighBound(array1, 2));
    int[] array2 = new int[]{1, 3, 6, 9, 10, 10, 10, 10, 31, 48, 48, 55};
    System.out.println(search4BothBound(array2, 2));
    System.out.println(search4BothBound(array2, 3));
    System.out.println(search4BothBound(array2, 48));
    System.out.println(search4BothBound(array2, 10));
    System.out.println(search4BothBound(new int[]{5}, 5));
    System.out.println(search4BothBound(new int[]{5}, 2));
    int[] rollArray = new int[]{6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5};
    System.out.println(searchInRollArray(rollArray, 9));
    System.out.println(searchInRollArray(rollArray, 5));
  }

}
