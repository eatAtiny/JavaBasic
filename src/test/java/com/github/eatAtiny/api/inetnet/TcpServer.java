package com.github.eatAtiny.api.inetnet;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.junit.jupiter.api.Test;

/**
 * TcpServer class demonstrates a simple TCP server implementation. It listens for incoming
 * connections on port 8888, receives data from a client, and sends a response back to the client.
 */
public class TcpServer {

  @Test
  public void tcpServerDemo() {
    // 使用TCP协议接收数据

    try (ServerSocket serverSocket = new ServerSocket(8888)) { // 创建ServerSocket对象，绑定到指定端口
      // 监听端口，等待客户端连接
      System.out.println("TCP Server is running, waiting for client connection...");
      Socket socket = serverSocket.accept(); // 等待客户端连接

      InputStream inputStream = new BufferedInputStream(socket.getInputStream()); // 获取输入流
      byte[] buffer = new byte[1024]; // 创建接收缓冲区
      int bytesRead = inputStream.read(buffer); // 读取数据
      String receivedData = new String(buffer, 0, bytesRead); // 处理接收到的数据
      System.out.println("Received data: " + receivedData); // 打印接收到的数据
      // 发送响应数据
      String response = "Hello, TCP Client!";
      socket.getOutputStream().write(response.getBytes()); // 发送响应数据
      socket.getOutputStream().flush(); // 确保数据被发送
      System.out.println("Response sent to client: " + response); // 打印发送的响应数据
      // 关闭Socket连接
      socket.close(); // 关闭Socket连接

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
