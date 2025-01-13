package network.tcp.v4;

import static util.MyLogger.log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerV4 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");

        // 서버 소캣 시작되어 해당 포트의 요청이 올 때까지 떠있게 된다.
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트 : " + PORT);

        while (true) {
            Socket socket = serverSocket.accept(); // 블로킹 메서드
            log("소켓 연결 : " + socket);

            SessionV4 session = new SessionV4(socket);
            Thread thread = new Thread(session);
            thread.start();
        }
    }
}
