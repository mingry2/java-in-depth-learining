package io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class NewFilesMain {

    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");

        //Files -> static 클래스를 통해

        //존재여부
        System.out.println("Files exists: " + Files.exists(file));
        System.out.println("Directory exists: " + Files.exists(directory));

        //생성 - FileAlreadyExistsException 예외
        try {
            Files.createFile(file);
        } catch (FileAlreadyExistsException e) {
            System.out.println(file + " File already exists");
        }

        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException e) {
            System.out.println(directory + " Directory already exists");
        }

        //삭제
//        Files.delete(file);
//        System.out.println("File deleted: ");

        //파일?디렉토리? 여부
        System.out.println("Is regular file: " + Files.isRegularFile(file));
        System.out.println("Is directory: " + Files.isDirectory(directory));

        //파일 이름
        System.out.println("File name: " + file.getFileName());

        //파일 사이즈
        System.out.println("File size: " + Files.size(file) + " bytes");

        //파일 복사
        Path newFile = Path.of("temp/newExample.txt");
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING); //교체

        //마지막 수정 일시
        System.out.println("Last modified: " + Files.getLastModifiedTime(file));

        //파일 속성 한번에 얻기
        BasicFileAttributes attrs = Files.readAttributes(newFile,
            BasicFileAttributes.class);
        System.out.println("=== Attributes ===");
        System.out.println("Creation time: " + attrs.creationTime());
        System.out.println("Last modification time: " + attrs.lastModifiedTime());
        System.out.println("Is directory: " + Files.isDirectory(newFile));
        System.out.println("Is regular file: " + Files.isRegularFile(newFile));
        System.out.println("Is symbolic link: " + Files.isSymbolicLink(newFile));

    }

}
