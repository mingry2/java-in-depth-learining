package io.text;

import static io.text.TextConst.FILE_NAME;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String writeString = "abd\n가나다";
        System.out.println("== Write string ==");
        System.out.println("writeString: " + writeString);

        //1. 파일 쓰기
        FileWriter fw = new FileWriter(FILE_NAME, StandardCharsets.UTF_8);
        //버퍼 기능 추가
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        //2. 파일에서 읽기
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        //라인단위로 읽기
        String line;
        while ((line = br.readLine()) != null) { // -1 반환 불가 null로 끝을 확인
            content.append(line).append("\n");
        }
        fr.close();

        System.out.println("== Read String ==");
        System.out.println(content);
    }
}
