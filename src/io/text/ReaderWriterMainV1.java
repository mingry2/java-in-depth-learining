package io.text;

import static java.nio.charset.StandardCharsets.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReaderWriterMainV1 {

    // 문자로 읽고 쓰기
    // 스트림은 byte만 사용할 수 있으므로 개발자가 번거롭게 String <-> byte 인코딩 디코딩을 다 해야한다.
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        //1. 문자 -> byte UTF-8 인코딩 : {65,66,67}
        byte[] writeBytes = writeString.getBytes(UTF_8);
        System.out.println("write String : " + writeString);
        System.out.println("write bytes : " + Arrays.toString(writeBytes));

        //2. 파일에 쓰기
        FileOutputStream fos = new FileOutputStream(TextConst.FILE_NAME);
        fos.write(writeBytes);
        fos.close();

        //3. 파일 읽기
        FileInputStream fis = new FileInputStream(TextConst.FILE_NAME);
        byte[] readBytes = fis.readAllBytes();
        fis.close();

        //4. byte -> String UTF-8 디코딩
        String readString = new String(readBytes, UTF_8);
        System.out.println("read bytes : " + Arrays.toString(readBytes));
        System.out.println("read String : " + readString);
    }

}
