package test.api.inetnet;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClient {

    @Test
    public  void udpClientDemo() {
        // 使用UDP协议发送数据
        // 1. 创建DatagramSocket对象
        // 2. 创建DatagramPacket对象，指定要发送的数据、数据长度、目标地址和端口
        // 3. 使用DatagramSocket的send方法发送数据包
        // 4. 关闭DatagramSocket

        // 注意：UDP是无连接的协议，不需要建立连接，直接发送数据包即可。
        // UDP协议适用于实时性要求高、数据量小的场景，如视频直播、在线游戏等。
        // 下面是一个简单的UDP客户端示例代码

        try (DatagramSocket socket = new DatagramSocket();) {// 创建一个DatagramSocket对象，绑定到随机端口

            DatagramPacket packet = new DatagramPacket( // 创建一个DatagramPacket对象
                    "Hello, UDP Server".getBytes(), // 要发送的数据
                    "Hello, UDP Server".length(), // 数据长度
                    java.net.InetAddress.getByName("localhost"), // 目标地址
                    9876 // 目标端口
            );
            socket.send(packet); // 发送数据包

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
