package com.jinming.com.obj;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class ClassThree {
    // 包装类型
    public  void testOne() {
        Integer a = new Integer(15);
        Integer a1 = new Integer(10);
        a1 = 20;
        System.out.println(a1);
        a1 = a;
        System.out.println(a1);
    }

    // JavaBean
    public void testTwo() throws IntrospectionException {
        class Bean {
            private String name;
            private int age;

            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public int getAge() {
                return age;
            }
            public void setAge(int age) {
                this.age = age;
            }
        }

        // 枚举Javabean 属性
        // 要枚举一个JavaBean的所有属性，可以直接使用Java核心库提供的Introspector：
        BeanInfo info = Introspector.getBeanInfo(Bean.class);
        for (PropertyDescriptor pd: info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("" + pd.getReadMethod());
            System.out.println("" + pd.getWriteMethod());
        }
    }
}
