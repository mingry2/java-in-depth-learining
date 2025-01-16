package reflection;

import java.lang.reflect.Method;
import reflection.data.BasicData;

public class MethodV1 {

    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        System.out.println("==== methods() ====");
        Method[] methods = helloClass.getMethods(); // 해당클래스 + 상속 + public 메서드
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        System.out.println("==== declaredMethods() ====");
        Method[] declaredMethods = helloClass.getDeclaredMethods();
        for (Method method : declaredMethods) { // 해당클래스 + 상속X + 모든 메서드
            System.out.println("declaredMethod = " + method);
        }


    }

}
