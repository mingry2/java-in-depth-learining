package annotation.basic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import util.MyLogger;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoElement {

    String value(); // 매개변수 X, 반환타입 필수, 예외 선언 불가
    int count() default 0;
    String[] tags() default {};

    // 기본타입만 선언 가능(직접 만든 참조타입은 선언 불가-Member,User 등)
    Class<? extends MyLogger> annoData() default MyLogger.class;

}
