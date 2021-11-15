package com.jinming.com.obj;

import java.util.StringJoiner;

public class ClassTwo {
    private  String name;

    ClassTwo(String name) {
        this.name = name;
    }

    // 字符串基本操作
    public void testOne() {
        // 字符串比较
        // CharSequence是String的父类
        String n = "aaaa";
        String b = "bbbb";

        // 字符串是否相同
        boolean v1 = n.equals(b);
        boolean v2 = n.equalsIgnoreCase(b);

        // 字符串是否包含子字符串
        boolean v3 = n.contains("aaa");

        // 字符串中第一次出现字符的索引。
        int i1 = n.indexOf("a");
        int i2 = n.lastIndexOf("a");
        // 字符串开头的字符
        boolean a1 = n.startsWith("a");
        // endsWith

        // 截取子字符串
        "Hello".substring(2); // "llo"
        "Hello".substring(2, 4); // "ll";

        // trim()方法可以移除字符串首尾空白字符。空白字符包括空格，\t，\r，\n：
        // trim()并没有改变字符串的内容，而是返回了一个新字符串。

        // 另一个strip()方法也可以移除字符串首尾空白字符。它和trim()不同的是，类似中文的空格字符\u3000也会被移除：
        // java 11
        /**
         * repeat(int)-将字符串重复int参数提供的次数
         * lines()-使用分隔符从源字符串懒惰地提供行
         * isBlank()-指示字符串是否为空或仅包含空格字符
         * stripLeading()-从开头删除空白
         * stripTrailing()-从末尾删除空白
         * strip()-删除字符串开头和结尾的空格
         * */
        // 替换字符
        n.replace('a', 'w');
        // 分割字符串
        String[] k = n.split("\\,");
        // 拼接字符串
        String[] arr = {"A", "B", "C"};
        String a = String.join("===", arr);
        // 格式化字符串
        String v = String.format("aaa %s", "BP");

        // 类型转换
        // 要把任意基本类型或引用类型转换为字符串，可以使用静态方法valueOf()
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object());
        // 字符串转换为其他类型
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255

        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false
    }

    // StringBuilder
    public void testTwo() {
        // 1. 循环拼接字符串，每次循环都会创建新的字符串对象，然后丢掉旧的字符串。 这样大部分字符串都是临时对象，不但浪费内存，还影响
        // GC 效率。 为了高效拼接字符串。Java 提供了StringBuilder, 它是一个可变对象，可以预分配缓冲区。新增字符时，不会创建临时对象。
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i ++) {
            sb.append(',');
            sb.append(i);
        }
        String s = sb.toString();
        System.out.println(s);

        // StringBuilder 还可以进行链式操作
        sb.append("啊啊啊")
                .append("bbb")
                .insert(0, "hello");
        System.out.println(sb.toString());
        // 查看StringBuilder的源码，可以发现，进行链式操作的关键是，定义的append()方法会返回this，这样，就可以不断调用自身的其他方法.
        // 演示链式操作的原理
        class Adder {
            private int sum = 0;

            public Adder add(int n) {
                sum += n;
                return this;
            }
            public int value() {
                return sum;
            }
        }

        Adder ad = new Adder();
        ad.add(3)
                .add(4);
        System.out.println(ad.value());

    }

    // StringJoiner
    public void testThree() {
        // 分隔符拼接数组的需求很常见，所以Java标准库还提供了一个StringJoiner来干这个事
        String [] k = {"aaaa", "bbb", "aaaa"};

        StringJoiner sj = new StringJoiner(",");
        for (String name : k) {
            sj.add(name);
        }
        System.out.println(sj.toString());
        // 分割符，拼接头，拼接尾
        StringJoiner sk = new StringJoiner(",", "Hello", "!");
        for (String name : k) {
            sk.add(name);
        }
        System.out.println(sk.toString());
        // 不需要拼接头和尾，可以直接使用内部方法， 11 以下 var 关键字不支持。
        //var ssj = String.join("k", k);
        //System.out.println(ssj);
    }


}
