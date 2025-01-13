package network.tcp.v4;

import static network.tcp.SocketCloseUtil.*;
import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import network.tcp.SocketCloseUtil;

public class ClientV4 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        // finally 블록에서 변수에 접근해야하기 때문에 try 블록 안에서 선언할 수 없음
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;

        try {
            socket = new Socket("localhost", PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            log("소켓 연결 : " + socket);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("전송 문자 : ");
                String toSend = scanner.nextLine();

                output.writeUTF(toSend);
                log("client -> server : " + toSend);

                if (toSend.equals("exit")) {
                    break;
                }

                String received = input.readUTF();
                log("client <- server : " + received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            closeAll(socket, input, output);
            log("연결 종료 : " + socket);
        }

    }

}
