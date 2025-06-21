package com.github.eatAtiny.api.iostream;

import java.io.*;
import org.junit.jupiter.api.Test;

public class TransIOTest {

  @Test
  public void transIoStreamDemo() {
    // 转换流是Java中用于处理字符和字节之间转换的类，位于java.io包中。
    // 主要包括InputStreamReader、OutputStreamWriter等类。
    // 转换流可以将字节流转换为字符流，或者将字符流转换为字节流。
    // 适用于处理文本文件的读写操作。
    // InputStreamReader用于将字节流转换为字符流，OutputStreamWriter用于将字符流转换为字节流。

    // 示例代码：使用InputStreamReader和OutputStreamWriter进行文本文件读写
    try (InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"), "UTF-8");
        OutputStreamWriter osw =
            new OutputStreamWriter(new FileOutputStream("output.txt"), "UTF-8")) {
      int data;
      while ((data = isr.read()) != -1) { // 逐字符读取文件内容
        osw.write(data); // 将读取的内容写入到输出文件，一次写入一个字符
      }
      System.out.println("转换流文件读写操作完成");
    } catch (IOException e) {
      e.printStackTrace(); // 捕获并打印异常信息
    }

    // 可以使用缓冲流来包装转换流来提高IO效率
    try (BufferedReader br =
            new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "UTF-8"));
        BufferedWriter bw =
            new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("output.txt"), "UTF-8"))) {
      String line;
      while ((line = br.readLine()) != null) { // 逐行读取文件内容
        bw.write(line); // 将读取的内容写入到输出文件
        bw.newLine(); // 写入换行符
      }
      System.out.println("缓冲转换流文件读写操作完成");
    } catch (IOException e) {
      e.printStackTrace(); // 捕获并打印异常信息
    }
  }
}
