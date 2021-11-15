package com.jinming.com;

import com.jinming.com.annotation.CustomDescription;
import com.jinming.com.annotation.CustomDescriptions;
import com.jinming.com.annotation.Student;
import com.jinming.com.basic.Basic;
import com.jinming.com.obj.ClassFive;
import com.jinming.com.obj.ClassOne;
import com.jinming.com.obj.ClassThree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
	// write your code here
        System.out.println("hello world ！！！");
        // Java 注解是附加在代码中的元信息，便于一些工具在编译，运行时进行解析和使用，起到说明，配置的功能。

        // 反射获取注解属性值
        CustomDescriptions customDescriptions = new Student().getClass().getAnnotation(CustomDescriptions.class);
        for (CustomDescription cu : customDescriptions.value()) {
            System.out.println("description = " + cu.description());
        }

        // 反射
        /**
         * Class 也是一个类，只是它是一个描述类的类，也可以生成对象。
         * Class 类型的对象只能由系统建立，可以叫类的实例对象。
         * */
        // 获取Class 对象
        Class clazz = null;
        clazz = String.class;
        System.out.println(clazz);
        clazz = "牛逼plus".getClass();
        System.out.println(clazz);
        clazz = Class.forName("java.lang.String");
        System.out.println(clazz);

        // 描述方法Method
        /**
         * getMethods 获取本身类和其所有父类的所有共同方法 (public)。
         * getMethod 获取本身类和其所有父类指定方法名和参数类型的方法。 后面规则同上。
         * getDeclaredMethods 只获取当前类，所有方法，包括私有方法，所有声明的方法。
         * getDeclaredMethod 只获取当前类，指定方法名和参数类型的方法。
         * 调用方法invoke
         * */
        Class clazz1 = Class.forName("com.jinming.com.annotation.Student");
        Method method = null;
        Method[] methods = null;

        methods = clazz1.getMethods();
        for (Method th : methods) {
            System.out.println("methods : " + th.getName() + "");
        }
        method = clazz1.getMethod("StudentPublicMethod", String.class);
        System.out.println("method : " + method.getName() + "");

        method = clazz1.getDeclaredMethod("StudentPrivateMethod", String.class);
        // 执行私有方法，需要在调用invoke之前增加一句"method.setAccessible(true)"
        Object obj = clazz1.newInstance();
        method.setAccessible(true);
        String result = (String) method.invoke(obj, "params");
        System.out.println("result = : " + result);

    }
}
