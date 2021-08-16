package com.design_pattern.singleton;

/**
 * 推荐，相当于将实例化放进JVM启动过程中完成。
 * 只是会增加JVM启动时间，故称 饿汉式
 * 而其线程安全来源于JVM类加载特性，类加载的几个步骤：加载、链接、初始化
 * 类变量会在链接的准备阶段赋上零值，然后在初始化阶段给其赋初始值，JVM保证了这一步骤的线程安全。
 */
public class HungryMan {

  // 这里可以为常量，更能保证只有一个值
  private static HungryMan instance = new HungryMan();

  private HungryMan(){}

  public static HungryMan getInstance() {
    return instance;
  }
}