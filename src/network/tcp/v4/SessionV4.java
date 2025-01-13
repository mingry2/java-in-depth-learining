package network.tcp.v4;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import network.tcp.SocketCloseUtil;

public class SessionV4 implements Runnable{

    private final Socket socket;

    public SessionV4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // finally 블록에서 변수에 접근해야하기 때문에 try 블록 안에서 선언할 수 없음
        DataInputStream input = null;
        DataOutputStream output = null;
        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            while (true) {
                // 클라이언트로부터 문자 받기
                String received = input.readUTF();
                log("client -> server : " + received);

                if (received.equals("exit")) {
                    break;
                }

                // 클라이언트에게 문자 보내기
                String toSend = received + " World";
                output.writeUTF(toSend);
                log("client <- server : " + toSend);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            SocketCloseUtil.closeAll(socket, input, output);
            log("연결 종료 : " + socket);
        }
    }
}
