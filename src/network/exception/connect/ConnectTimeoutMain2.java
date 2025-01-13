package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ConnectTimeoutMain2 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        try {
            Socket socket = new Socket(); // 연결X
            // 타임아웃 설정
            socket.connect(new InetSocketAddress("192.168.1.250", 45678), 3000);
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("end = " + (endTime - startTime));
    }

}
