package NET;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet1 = InetAddress.getByName("192.168.10.4");
        System.out.println(inet1);

        InetAddress inet2 = InetAddress.getByName("127.0.0.1");
        System.out.println(inet2);

        InetAddress inet3 = InetAddress.getLocalHost();
        System.out.println(inet3);

        System.out.println(inet1.getHostName());
        System.out.println(inet2.getAddress());
    }
}
