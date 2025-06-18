package test.api.inetnet;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressTest {

    @Test
    public void InetAddressDemo1() {

        try {
            // 获取本机IP地址和主机名
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("本机IP地址: " + localHost.getHostAddress());
            System.out.println("本机主机名: " + localHost.getHostName());

            // 获取对方IP地址和主机名
            InetAddress remoteHost = InetAddress.getByName("www.baidu.com");
            System.out.println("对方IP地址: " + remoteHost.getHostAddress());
            System.out.println("对方主机名: " + remoteHost.getHostName());

            // 判断本机与对方是否可达
            System.out.println("本机是否可达对方: " + localHost.isReachable(2000)); // 2000毫秒超时
        } catch (java.net.UnknownHostException e) {
            System.err.println("无法获取本机IP地址和主机名: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
