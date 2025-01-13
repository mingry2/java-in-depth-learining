package network.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SoTimeoutClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        InputStream input = socket.getInputStream();

        try {
            socket.setSoTimeout(3000); // 타임아웃 시간 설정 가능 -> 설정하지 않으면 무한대기
            int read = input.read(); // 응답요청
            System.out.println("read = " + read);
        } catch (Exception e) {
            e.printStackTrace();
        }
        socket.close();
    }

}
