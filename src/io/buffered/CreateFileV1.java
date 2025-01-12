package io.buffered;

import static io.buffered.BufferedConst.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV1 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);

        // 파일 생성 시간
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < FILE_SIZE; i++) {
            fos.write(1); // 1byte * 10MB = 10MB 파일 생성
        }

        fos.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File create : " + FILE_NAME);
        System.out.println("File size : " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken : " + (endTime - startTime) + "ms");
    }

}
