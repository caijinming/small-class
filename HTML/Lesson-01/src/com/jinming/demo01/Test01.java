package com.jinming.demo01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义注解
public class Test01 {

    @MyAnnotation(name = "ming")
    public void test() {

    }

    @MyAnnotation2("aaaa")
    public void testFour() {

    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    // 注解的参数 ：参数类型 + 参数名()
    // default 设置默认值
    String name() default "";
    int age() default 0;
    int id() default -1; // 如果默认为-1，代表不存在
    String [] schools() default {"aaa", "bbbb"};
}


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 如果自定义注解只有一个参数，建议用value， 这个注解在使用的时候可以省略。
    String value();
}


