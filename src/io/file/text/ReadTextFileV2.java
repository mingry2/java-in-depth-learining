package io.file.text;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadTextFileV2 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String wrtieString = "abc\n가나다";
        System.out.println("== Write String ==");
        System.out.println(wrtieString);

        Path path = Path.of(PATH);

        //파일에 쓰기
        Files.writeString(path, wrtieString, UTF_8);

        //파일에서 읽기 - 한줄씩 읽기
        System.out.println("== Read String ==");
        List<String> lines = Files.readAllLines(path, UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));

        }
    }

}
