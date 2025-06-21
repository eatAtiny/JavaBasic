package com.github.eatAtiny.api;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * list是Java中常用的数据结构之一，是一种线性表结构 Lists是Java中常用的数据结构之一，提供了动态数组的功能。
 * ArrayList是List的一个实现，提供了动态数组的功能。LinkedList是List的另一个实现，提供了链表的功能。
 */
public class ListTest {
  /** 数组是Java中最基本的数据结构，但它的大小是固定的。 */
  @Test
  public void arrayDemo() {
    // 创建一个整数数组，长度为5
    int[] numbers = new int[5];

    // 给数组赋值
    numbers[0] = 1;
    numbers[1] = 2;
    numbers[2] = 3;
    numbers[3] = 4;
    numbers[4] = 5;

    // 遍历数组
    for (int number : numbers) {
      System.out.println(number);
    }

    // 获取数组长度
    System.out.println("数组长度: " + numbers.length); // 输出 5

    // 数组是固定大小的，不能动态增加或减少
  }

  /** 测试ArrayList的创建和常用方法 */
  @Test
  public void arrayListDemo() {
    // 静态创建
    // 创建一个ArrayList，存储字符串类型的元素
    ArrayList<String> alist = new ArrayList<>(List.of("a", "b", "c"));

    // ArrayList是一个动态数组，支持自动扩容
    java.util.ArrayList<String> list = new ArrayList<>();

    // 添加元素
    list.add("hello");
    list.add("world");

    // 获取元素
    String firstElement = list.get(0);
    System.out.println(firstElement); // 输出 "hello"

    // 遍历元素
    for (String item : list) {
      System.out.println(item);
    }

    // 删除元素
    list.remove("hello");
    System.out.println(list.size()); // 输出 1

    // 检查是否包含某个元素
    boolean containsWorld = list.contains("world");
    System.out.println(containsWorld); // 输出 true

    // 清空列表
    list.clear();
    System.out.println(list.isEmpty()); // 输出 true
  }

  /** 测试LinkedList的创建和常用方法 */
  @Test
  public void linkedListDemo() {
    // LinkedList是一个双向链表，支持快速插入和删除
    java.util.LinkedList<String> linkedList = new java.util.LinkedList<>();

    // 添加元素
    linkedList.add("hello");
    linkedList.add("world");

    // 获取元素
    String firstElement = linkedList.get(0);
    System.out.println(firstElement); // 输出 "hello"

    // 遍历元素
    for (String item : linkedList) {
      System.out.println(item);
    }

    // 删除元素
    linkedList.remove("hello");
    System.out.println(linkedList.size()); // 输出 1

    // 检查是否包含某个元素
    boolean containsWorld = linkedList.contains("world");
    System.out.println(containsWorld); // 输出 true

    // 清空列表
    linkedList.clear();
    System.out.println(linkedList.isEmpty()); // 输出 true
  }
}
