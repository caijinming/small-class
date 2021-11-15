package com.ssm.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAssembleTest {
    private static ApplicationContext applicationContext;
    public static  void main(String[] args) {
        // 定义配置文件路径
        applicationContext = new ClassPathXmlApplicationContext("beans1.xml");
        // 获取UserController实例
        UserController userController = (UserController)applicationContext.getBean("userController");
        userController.save();
    }
}
