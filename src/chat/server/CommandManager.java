package chat.server;

import java.io.IOException;

//클라이언트가 명령어를 보내면 실행하는 인터페이스
public interface CommandManager {
    void execute(String totalMessage, Session session) throws IOException;

}
