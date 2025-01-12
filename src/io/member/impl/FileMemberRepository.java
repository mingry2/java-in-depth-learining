package io.member.impl;

import static java.rmi.server.LogStream.log;

import io.member.Member;
import io.member.MemberRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-txt.dat";
    private static final String DELIMITER = ",";

    @Override
    public void add(Member member) {
        // try-with-resources 구문
        // try("AutoCloseable 인터페이스를 구현한 구현체를 선언") -> try 블록이 끝난후 해당 리소스의
        // close() 메서드를 자동으로 호출
        // AutoCloseable 구현체 -> BufferedWriter, FileWriter
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(
                member.getId() +
                    DELIMITER + member.getName() +
                    DELIMITER + member.getAge());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                // id1,name1,30
                String[] memberData = line.split(DELIMITER);
                members.add(
                    new Member(memberData[0], memberData[1], Integer.valueOf(memberData[2])));
            }
            return members;
        }catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
