package com.jinming.com.obj;

public class ClassFour {
    // 单例类
    //1. 只允许该类创建一个对象，为了避免自由创建该类的实例，需要把构造器用private 隐藏起来。
    //2. 需要提供一个public方法做为类的访问点，用于创建该类对象，且需要static 修饰，因为调用这个方法的只能是类。
    //3. 该类必须缓存已经创建的对象，否则无法知道是否曾经创建过对象。隐藏需要一个static修饰的成员变量，因为成员变量需要在静态方法里访问。
    private  static  ClassFour instance = null;
    private ClassFour() {

    }
    public  static  ClassFour shareInstance() {
        if (null == instance) {
            instance = new ClassFour();
        }
        return instance;
    }
}
