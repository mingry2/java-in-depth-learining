package network.tcp.v5;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientV5 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        try (Socket socket = new Socket("127.0.0.1", PORT);
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             DataInputStream input = new DataInputStream(socket.getInputStream());) {

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
        }

    }

}
