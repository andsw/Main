package com.design_pattern.singleton;

/**
 * 懒汉式单例写法
 */
public class LazyInit {

  private static LazyInit instance;

  private LazyInit() {}

  // Thread unsafe
  public static LazyInit getInstance() {
    if (instance == null) {
      instance = new LazyInit();
    }
    return instance;
  }

  // thread safe
  public static LazyInit getInstance2() {
    if (instance == null) {
      synchronized (LazyInit.class) {
        if (instance == null) {
          instance = new LazyInit();
        }
      }
    }
    return instance;
  }
}