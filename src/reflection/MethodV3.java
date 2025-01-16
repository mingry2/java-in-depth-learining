package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import reflection.data.Calculator;

public class MethodV3 {

    public static void main(String[] args)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("호출 메서드: ");
        String methodName = scanner.nextLine();
        System.out.print("숫자1: ");
        int num1 = scanner.nextInt();
        System.out.println("숫자2: ");
        int num2 = scanner.nextInt();

        Calculator calculator = new Calculator();
        // 호출할 메서드를 변수 이름을 동적으로 선택
        Class<? extends Calculator> calculatorClass = calculator.getClass();
        Method method = calculatorClass.getDeclaredMethod(methodName, int.class, int.class);
        Object returnValue = method.invoke(calculator, num1, num2);
        System.out.println("returnValue = " + returnValue);
    }

}
