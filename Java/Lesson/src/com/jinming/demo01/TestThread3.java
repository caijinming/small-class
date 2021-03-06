package com.jinming.demo01;

// Runnable 实践
public class TestThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码 === " + i);
        }
    }

    public static void main(String[] args) {
        // 创建Runnable 接口的实现类对象
        TestThread3 testThread3 = new TestThread3();

        /*// 创建线程对象，通过线程对象开启我们的线程，代理
        Thread thread = new Thread(testThread3);

        // 执行线程
        thread.start();*/
        new Thread(testThread3).start();

        for (int i = 0; i <100 ; i++) {
            System.out.println("我在学习多线程 === " + i);
        }
    }
}
