package network.tcp.v2;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientV2 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        // tcp 커넥션을 통해 localhost:PORT로 접근 (소켓 연결 완료)
        // tcp/ip 통신!
        Socket socket = new Socket("localhost", PORT);

        // 외부에 데이터를 보내고 받는다.
//        socket.getInputStream();
//        socket.getOutputStream();

        // 보조 스트림에 감싸서 사용
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        log("소켓 연결 : " + socket);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("전송 문자 : ");
            String toSend = scanner.nextLine();

            // 서버에게 문자 보내기
            output.writeUTF(toSend);
            log("client -> server : " + toSend);

            if (toSend.equals("exit")) {
                break;
            }

            // 서버로부터 문자 받기
            String received = input.readUTF();
            log("client <- server : " + received);
        }

        // 자원정리
        log("연결 종료 : " + socket);
        input.close();
        output.close();
        socket.close();
    }

}
