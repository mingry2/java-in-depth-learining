package network.tcp.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

    // ip 주소 확인
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(localhost);

        InetAddress google = InetAddress.getByName("google.com");
        System.out.println(google);

    }

}
