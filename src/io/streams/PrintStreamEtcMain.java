package io.streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEtcMain {

    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp/print.txt");
        PrintStream printStream = new PrintStream(fos);

        printStream.println("Hello World");
        printStream.println(10);
        printStream.println("Hello World");
        printStream.println(true);
        printStream.println("Hello World");
        printStream.close();
    }

}
