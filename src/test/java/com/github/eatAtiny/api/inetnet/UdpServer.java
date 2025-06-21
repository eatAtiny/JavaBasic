package com.github.eatAtiny.api.inetnet;

import org.junit.jupiter.api.Test;

public class UdpServer {

  @Test
  public void udpServerDemo() {
    // 使用upd接收数据包

    // 1. 创建DatagramSocket对象，指定端口号
    // 2. 创建DatagramPacket对象，指定接收缓冲区大小
    // 3. 使用DatagramSocket的receive方法接收数据包
    // 4. 处理接收到的数据
    // 5. 关闭DatagramSocket

    // 注意：UDP是无连接的协议，不需要建立连接，直接接收数据包即可。

    try (java.net.DatagramSocket socket =
        new java.net.DatagramSocket(9876)) { // 创建一个DatagramSocket对象，绑定到指定端口

      byte[] buffer = new byte[1024]; // 创建接收缓冲区
      java.net.DatagramPacket packet =
          new java.net.DatagramPacket(buffer, buffer.length); // 创建DatagramPacket对象

      System.out.println("UDP Server is running, waiting for data...");
      socket.receive(packet); // 接收数据包

      String receivedData = new String(packet.getData(), 0, packet.getLength()); // 处理接收到的数据
      System.out.println("Received data: " + receivedData);

    } catch (java.io.IOException e) {
      throw new RuntimeException(e);
    }
  }
}
