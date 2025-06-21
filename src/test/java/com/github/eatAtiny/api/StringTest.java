package com.github.eatAtiny.api;

import org.junit.jupiter.api.Test;

public class StringTest {
  /** 测试字符串的创建和常用方法 注意：String是不可变的，一旦创建就不能修改 */
  @Test
  public void stringDemo() {
    // 推荐方式 此时存储到字符串常量池，相同的内容只放一份
    String str1 = "hello";
    // 此时的对象是存放到堆中的，与上面的不是同一个对象
    String str2 = new String("hello");
    char[] chars = {'h', 'e', 'l', 'l', 'o'};
    String str3 = new String(chars);
    byte[] bytes = {97, 98, 99};
    String str4 = new String(bytes);
    // 字符串对象之间使用==比较的是地址
    System.out.println(str1 == str2);
    // 使用equal比较的是内容
    System.out.println(str1.equals(str2));

    // string常用api
    // 截取字符串长度返回新的字符串
    String str5 = str1.substring(0, 3);
    System.out.println(str5);
    // 字符串拼接
    String str6 = str1 + " world";
    System.out.println(str6);
    // 字符串拼接的另一种方式
    String str7 = String.join(" ", str1, "world");
    System.out.println(str7);
    // 字符串转换为字符数组
    char[] charArray = str1.toCharArray();
    for (char c : charArray) {
      System.out.print(c + " ");
    }
    // 字符串的不可变性
    String str = "hello";
    str = str + " world"; // 重新赋值，原来的字符串不变
    System.out.println(str); // 输出 "hello world"
  }

  @Test
  public void stringBuilderDemo() {
    // StringBuilder是可变的，适合频繁修改字符串的场景
    StringBuilder sb = new StringBuilder("hello");
    sb.append(" world"); // 拼接字符串
    System.out.println(sb.toString()); // 输出 "hello world"
    sb.insert(5, ","); // 在指定位置插入字符
    System.out.println(sb.toString()); // 输出 "hello, world"
    sb.delete(5, 6); // 删除指定范围的字符
    System.out.println(sb.toString()); // 输出 "hello world"
    sb.reverse(); // 反转字符串
    System.out.println(sb.toString()); // 输出 "dlrow olleh"
  }
}
