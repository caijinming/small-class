package com.jinming.demo01;

// Thread 实现线程
public class TestThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习"+i);
        }
    }

    public static void main(String[] args) {

        TestThread1 thread1 = new TestThread1();
        thread1.start();

        for (int i = 0; i < 20 ; i++) {
            System.out.println("我在学习多线程"+i);
        }
    }
}
