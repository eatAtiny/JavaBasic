package test.api.inetnet;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

    @Test
    public void tcpClientDemo() {
        // 使用Tcp建立与服务端的连接

        // 1. 创建Socket对象，指定服务器地址和端口号
        // 2. 使用Socket的getOutputStream方法获取输出流
        // 3. 使用OutputStream的write方法发送数据
        // 4. 使用Socket的getInputStream方法获取输入流
        // 5. 使用InputStream的read方法接收数据
        // 6. 关闭Socket连接
        try (Socket socket = new Socket("127.0.0.1", 8888);
             OutputStream os = new BufferedOutputStream(socket.getOutputStream())) {
            // 创建Socket对象，连接到指定的服务器地址和端口号
            // 获取输出流
            // 发送数据
            String message = "Hello, TCP Server!";
            os.write(message.getBytes());
            os.flush(); // 确保数据被发送

            // 接收数据
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String response = new String(buffer, 0, bytesRead);
            System.out.println("Received from server: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
