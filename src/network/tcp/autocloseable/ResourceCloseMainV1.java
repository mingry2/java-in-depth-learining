package network.tcp.autocloseable;

public class ResourceCloseMainV1 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resourceV1 = new ResourceV1("resource1");
        ResourceV1 resourceV2 = new ResourceV1("resource2");

        resourceV1.call();
        resourceV2.callEx();

        System.out.println("자원 정리");
        resourceV2.closeEx();
        resourceV1.closeEx();
    }

}
