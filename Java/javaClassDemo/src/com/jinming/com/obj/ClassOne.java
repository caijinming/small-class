package com.jinming.com.obj;

public class ClassOne {
    public  String name;
    public  int age;
    public  String[] sisterOrBrother;
    private String school;

    // 构造方法
    public ClassOne () {

    }

    public ClassOne (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // public 标记外部可以访问， private 外部不可访问。
    public String getSchool() {
        return school;
    }

    // 方法内部，可以使用一个隐含的变量this
    public  void setSchool(String school) {
        this.school = school;
    }

    // 可变参数
    public  void  addSisterOrBrother(String ... names) {
        sisterOrBrother = names;
    }

    // 匿名类
    void asyncHello() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello" + name);
            }
        };
    }
}
