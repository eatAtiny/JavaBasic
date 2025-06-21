package com.github.eatAtiny.api;

import org.junit.jupiter.api.Test;

/**
 * * Maps是Java中常用的数据结构之一，提供了键值对的映射功能。
 * HashMap是Maps的一个实现，提供了基于哈希表的映射功能。TreeMap是Maps的另一个实现，提供了基于红黑树的映射功能。
 */
public class MapsTest {

  @Test
  public void hashMapDemo() {
    // HashMap是一个无序的映射，键值对不重复
    java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

    // 添加键值对
    map.put("apple", 1);
    map.put("banana", 2);
    map.put("orange", 3);

    // 尝试添加重复键
    Integer previousValue = map.put("apple", 4); // 返回之前的值1
    System.out.println("之前的值: " + previousValue);

    // 遍历键值对
    // 这个Entry类是Map接口的一个内部接口，表示映射中的键值对
    for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    // 检查是否包含某个键
    boolean containsBanana = map.containsKey("banana");
    System.out.println("映射中是否包含banana: " + containsBanana);

    // 获取映射大小
    System.out.println("映射大小: " + map.size());
  }

  @Test
  public void treeMapDemo() {
    // TreeMap是一个有序的映射，键值对不重复
    java.util.TreeMap<String, Integer> treeMap = new java.util.TreeMap<>();

    // 添加键值对
    treeMap.put("apple", 1);
    treeMap.put("banana", 2);
    treeMap.put("orange", 3);

    // 尝试添加重复键
    Integer previousValue = treeMap.put("apple", 4); // 返回之前的值1
    System.out.println("之前的值: " + previousValue);

    // 遍历键值对
    for (java.util.Map.Entry<String, Integer> entry : treeMap.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    // 检查是否包含某个键
    boolean containsBanana = treeMap.containsKey("banana");
    System.out.println("映射中是否包含banana: " + containsBanana);

    // 获取映射大小
    System.out.println("映射大小: " + treeMap.size());
  }
}
