package network.exception.close.reset;

import static util.MyLogger.log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ResetCloseClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결 : " + socket);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        // Client <- Server : FIN 전송
        Thread.sleep(1000); // 서버가 close() 호출할 때까지 잠시 대기

        // Client -> Server : FIN 전송 필요 하지만 PUSH[1]로 메시지를 전송하기(TCP/IP 규약에 어긋남)
        output.write(1);

        // Client <- Server : RST !!!
        Thread.sleep(1000); // RST 메시지 전송 대기

        try {
            int read = input.read();
            System.out.println("read = " + read);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            output.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

}
