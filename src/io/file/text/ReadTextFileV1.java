package io.file.text;

import static java.nio.charset.StandardCharsets.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadTextFileV1 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String wrtieString = "abc\n가나다";
        System.out.println("== Write String ==");
        System.out.println(wrtieString);

        Path path = Path.of(PATH);

        //파일에 쓰기
        Files.writeString(path, wrtieString, UTF_8);

        //파일에서 읽기
        String readString = Files.readString(path, UTF_8);

        System.out.println("== Read String ==");
        System.out.println(readString);
    }

}
