package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
    public static void main(String[] args) throws Exception {
//        Hello hello = new Hello();
//        hello.main(); //private이면 호출 불가

        // 웹에서는 왜 호출될까
        // = Reflection API를 사용하기 때문 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
        //java.lang.reflect 패키지를 제공
        //여기서도 쓰고 싶다면 =======
        // Hello 클래스의 클래스 객체(클래스의 정보를 담고 있는 객체)를 얻어온다
        Class helloClass = Class.forName("controller.Hello");
        //helloClass는 클래스에 대한 정보를 모두 갖고 있다
        Hello hello = (Hello)helloClass.newInstance();
        Method main = helloClass.getDeclaredMethod("main");

        main.setAccessible(true); //private인 main()을 호출가능하게 한다

        main.invoke(hello); //hello.main()한 거랑 같음

        //

    }
}
