package com.solution.leetcode;

import java.util.Stack;

/**
 * 只有加减乘除的四则运算
 */
public class ArithmeticExpressCalc227 {

  // 栈
  private static int solution1(String expr) {
    Stack<Integer> stack = new Stack<>();
    char preSign = '+';
    expr = expr + "+";
    StringBuilder sb = new StringBuilder();
    for (char c : expr.toCharArray()) {
      if (c == ' ') {
      } else if (c >= '0' && c <= '9') {
        sb.append(c);
      } else {
        int temp = Integer.parseInt(sb.toString());
        if (preSign == '+') {
          stack.push(temp);
        } else if (preSign == '-') {
          stack.push(-temp);
        } else if (preSign == '*') {
          stack.push(stack.pop() * temp);
        } else {
          stack.push(stack.pop() / temp);
        }
        sb.delete(0, sb.length());
        preSign = c;
      }
    }
    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }
    return sum;
  }

  // 递归
  // 最后一个测试用例超时
  private static int solution2(String expr) {
    expr = expr.trim();
    int plusIdx = expr.indexOf('+');
    if (plusIdx != -1) {
      return cal('+', solution2(expr.substring(0, plusIdx)),
          solution2(expr.substring(plusIdx + 1)));
    }
    int subIdx = expr.lastIndexOf('-');
    if (subIdx != -1) {
      return cal('-', solution2(expr.substring(0, subIdx)),
          solution2(expr.substring(subIdx + 1)));
    }
    int mulIdx = expr.lastIndexOf('*');
    int divIdx = expr.lastIndexOf('/');
    if (mulIdx != -1 && divIdx != -1) {
      if (mulIdx < divIdx) {
        return cal('/', solution2(expr.substring(0, divIdx)),
            solution2(expr.substring(divIdx + 1)));
      } else {
        return cal('*', solution2(expr.substring(0, mulIdx)),
            solution2(expr.substring(mulIdx + 1)));
      }
    }
    if (mulIdx != -1) {
      return cal('*', solution2(expr.substring(0, mulIdx)),
          solution2(expr.substring(mulIdx + 1)));
    }
    if (divIdx != -1) {
      return cal('/', solution2(expr.substring(0, divIdx)),
          solution2(expr.substring(divIdx + 1)));
    }
    return Integer.parseInt(expr);
  }

  private static int cal(char s, int a, int b) {
    switch (s) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      case '/':
        return a / b;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(solution1("5 * 6 / 2 + 1"));
    System.out.println(solution2("5 * 6 / 2 + 1"));
    System.out.println(solution1("3+5 / 2 "));
    System.out.println(solution2("3+5 / 2 "));
    System.out.println(solution1(" 3/2 "));
    System.out.println(solution2(" 3/2 "));
    System.out.println(solution1("1+2*5/3+6/4*2"));
    System.out.println(solution2("1+2*5/3+6/4*2"));
  }
}