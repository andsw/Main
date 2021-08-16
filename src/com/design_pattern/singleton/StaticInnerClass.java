package com.design_pattern.singleton;

/**
 * 静态内部类单例模式。
 * 这个看似和 饿汉式 同理，但其能避免增加JVM启动时间。
 * 因为当只有调用getInstance时，才回去加载静态内部类 InnerClass.
 * 启动 InnerClass 类加载过程。
 */
public class StaticInnerClass {

  private StaticInnerClass() {}

  private static StaticInnerClass getInstance() {
    return InnerClass.instance;
  }

  private static class InnerClass {
    // 可以为final，更保证只有一个值。
    private static StaticInnerClass instance = new StaticInnerClass();
  }
}