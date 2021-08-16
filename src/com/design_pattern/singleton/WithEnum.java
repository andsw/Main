package com.design_pattern.singleton;

/**
 * 公认为最好的单例模式实现方法
 * 原因：实现简单，且枚举类的几个值都相当于时类里面的常量！
 * 而且枚举是所有方式里面唯一一种不会被破坏的方式。
 * 比如 1. 其他方式的 private 构造方法 可以通过反射调用。
 *     2. 如果类是可序列化的，反序列化可以破坏其单例模式
 */
public class WithEnum {
  private enum InnerEnum {
    INSTANCE;
    private final WithEnum instance;

    InnerEnum() {
      this.instance = new WithEnum();
    }

    public WithEnum getInstance() {
      return instance;
    }
  }

  private WithEnum(){}

  private WithEnum getInstance() {
    return InnerEnum.INSTANCE.getInstance();
  }
}