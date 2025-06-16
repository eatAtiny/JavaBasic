package test.api.iostream;

import java.io.*;

public class BufferIOTest {

    public void bufferIoStreamDemo() {
        // BufferedInputStream和BufferedOutputStream是Java中用于处理文件读写的类，位于java.io包中。
        // 主要用于提高读写效率，提供缓冲功能。
        // BufferedInputStream和BufferedOutputStream提供了缓冲功能，可以提高读写效率。
        // Stream操作的流是字节流，适用于处理二进制数据，如图片、音频等。

        // 其实BufferedInputStream和BufferedOutputStream是对FileInputStream和FileOutputStream的包装，
        // 其在内部维护了一个缓冲区，默认大小为8192字节（8KB），可以提高读写效率。
        // 如果使用了FileInputStream和FileOutputStream进行文件读写操作，可能会因为频繁的磁盘I/O操作而导致性能下降。
        //

        // 示例代码：使用BufferedInputStream和BufferedOutputStream进行文件读写
        // 1. 创建BufferedInputStream和BufferedOutputStream
        // 2. 读取文件内容
        // 3. 写入文件内容
        // 4. 关闭流

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("input.txt"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output.txt"))) {
            // 读取文件内容
            int data;
            while ((data = bis.read()) != -1) { // 逐字节读取文件内容
                bos.write(data); // 将读取的内容写入到输出文件，一次写入一个字节
            }
            System.out.println("缓冲文件读写操作完成");
        } catch (IOException e) {
            e.printStackTrace(); // 捕获并打印异常信息
        }



    }

    public void bufferRW() {
        // BufferedReader和BufferedWriter是Java中用于处理文本文件读写的类，位于java.io包中。
        // 主要用于提高读写效率，提供缓冲功能。
        // BufferedReader和BufferedWriter是对Reader和Writer的包装，
        // 其在内部维护了一个缓冲区，默认大小为8192字节（8KB），可以提高读写效率。

        // 示例代码：使用BufferedReader和BufferedWriter进行文本文件读写
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) { // 逐行读取文件内容
                bw.write(line); // 将读取的内容写入到输出文件
                bw.newLine(); // 写入换行符
            }
            System.out.println("缓冲文本文件读写操作完成");
        } catch (IOException e) {
            e.printStackTrace(); // 捕获并打印异常信息
        }
    }
}
