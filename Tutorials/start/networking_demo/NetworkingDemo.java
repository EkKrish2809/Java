package start.networking_demo;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkingDemo {
    
    public static void main(String[] args) throws UnknownHostException {
        String url = "www.youtube.com";

        InetAddress inetAddr = Inet4Address.getByName(url);

        System.out.println("Address : " + Arrays.toString(inetAddr.getAddress()));
        System.out.println("Host Address : " + inetAddr.getHostAddress());
        System.out.println("isAnyLocalAddress : " + inetAddr.isAnyLocalAddress());
        System.out.println("isLinkLocalAddress : " + inetAddr.isLinkLocalAddress());
        System.out.println("isLoopbackAddress : " + inetAddr.isLoopbackAddress());
        System.out.println("isSiteLocalAddress : " + inetAddr.isSiteLocalAddress());
        System.out.println("hashCode : " + inetAddr.hashCode());
    }
}
