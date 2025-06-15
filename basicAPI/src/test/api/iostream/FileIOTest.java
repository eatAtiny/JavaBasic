package test.api.iostream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest {

    @Test
    public void fileIoStream() {
        // File类是Java中用于处理文件和目录的类，不能直接用于文件的读写操作。所以需要借助FileIOStream来操作文件中的内容。
        // 文件输入输出流是Java中用于处理文件读写的类，位于java.io包中。
        // 主要包括FileInputStream、FileOutputStream、BufferedInputStream、BufferedOutputStream等类。
        // BufferedInputStream和BufferedOutputStream提供了缓冲功能，可以提高读写效率。
        // Stream操作的流是字节流，适用于处理二进制数据，如图片、音频等。

        // 文件输入输出流的基本操作
        // 1. 创建文件输入流和输出流
        // 2. 读取文件内容
        // 3. 写入文件内容
        // 4. 关闭流

        // 示例代码：使用FileInputStream和FileOutputStream进行文件读写
        File file = new File("input.txt"); // 创建一个File对象，表示要操作的文件
        if (!file.exists()) { // 检查文件是否存在
            try {
                file.createNewFile(); // 如果文件不存在，则创建新文件
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (FileInputStream fis = new FileInputStream(file); // 创建文件输入流
             FileOutputStream fos = new FileOutputStream("output.txt")) { // 创建文件输出流，会默认调用file的构造函数
            // 读取文件内容
            int data;
            while ((data = fis.read()) != -1) { // 逐字节读取文件内容
                fos.write(data); // 将读取的内容写入到输出文件，一次写入一个字节
                // write方法会将字节写入到文件中，如果文件不存在，则会创建新文件
                // write方法会覆盖原有内容，如果需要追加内容，可以使用FileOutputStream的构造函数，传入第二个参数为true
                // // 例如：new FileOutputStream("output.txt", true);
                // write方法可以写入一个字节，也可以写入一个字节数组
                // // fos.write(new byte[]{data}); // 写入一个字节数组，还可以加入offset和length参数
                // fos.write(new byte[]{(byte) data}, 0, 1); // 写入一个字节数组，指定偏移量和长度
            }
            System.out.println("文件读写操作完成");

        } catch (Exception e) {
            e.printStackTrace(); // 捕获并打印异常信息
        }


        // 注意：在实际使用中，应该使用try-with-resources语句来自动关闭流，以避免资源泄漏。
        // 这样可以确保在使用完流后，自动调用close()方法关闭流，释放资源。
        // 就是在try语句中声明流对象，这样在try块执行完毕后，流会自动关闭，无需显式调用close()方法。

        //
    }

    @Test
    public void fileRw(){
        // FileWrite和FileReader是Java中用于处理文件读写的类，位于java.io包中。
        // 与FileInputStream和FileOutputStream不同，FileWriter和FileReader是字符流，适用于处理文本数据。
        // FileWriter用于写入字符到文件，FileReader用于从文件中读取字符。
        // 每次读取都是以字符为单位，读取的字节数根据字符编码而定。
        // 示例代码：使用FileWriter和FileReader进行文件读写
        File file = new File("input.txt"); // 创建一个File对象，表示要操作的文件
        if (!file.exists()) { // 检查文件是否存在
            try {
                file.createNewFile(); // 如果文件不存在，则创建新文件
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (java.io.FileWriter fw = new java.io.FileWriter(file); // 创建文件写入流
             java.io.FileReader fr = new java.io.FileReader(file)) { // 创建文件读取流
            // 写入文件内容
            fw.write("Hello, World!"); // 写入字符串到文件
            fw.flush(); // 刷新缓冲区，确保数据写入到文件

            // 读取文件内容
            char[] buffer = new char[1024]; // 创建字符数组作为缓冲区
            int length;
            while ((length = fr.read(buffer)) != -1) { // 逐字符读取文件内容
                System.out.print(new String(buffer, 0, length)); // 输出读取的内容
            }
            System.out.println("\n文件读写操作完成");

        } catch (IOException e) {
            e.printStackTrace(); // 捕获并打印异常信息
        }
    }


}
