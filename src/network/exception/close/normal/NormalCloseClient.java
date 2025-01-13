package network.exception.close.normal;

import static util.MyLogger.log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class NormalCloseClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결 : " + socket);
        InputStream input = socket.getInputStream();

//        readByInputStream(input, socket);
//        readByBufferedReader(input, socket);
        readByDataInputStream(input, socket);

        log("연결 종료: " + socket);
    }

    private static void readByInputStream(InputStream input, Socket socket) throws IOException {
        int read = input.read();
        log("read = " + read);
        if (read == -1) { // 서버에서 연결을 종료하면 FIN을 보냄 이 때 read도 -1을 반환
            input.close();
            socket.close();
        }
    }

    private static void readByBufferedReader(InputStream input, Socket socket) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String readString = br.readLine();
        log("readString = " + readString);
        if (readString == null) { // 서버에서 연결을 종료하면 FIN을 보냄 이 때 read도 null 반환
            br.close();
            socket.close();
        }
    }

    private static void readByDataInputStream(InputStream input, Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(input);

        try {
            dis.readUTF();
        } catch (EOFException e) { // 서버에서 연결을 종료하면 FIN을 보냄 이 때 read도 exception 발생
            log(e);
        } finally {
            dis.close();
            socket.close();
        }
    }
}
