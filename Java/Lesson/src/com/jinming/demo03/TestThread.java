package com.jinming.demo03;

import javax.swing.plaf.nimbus.State;

// 线程强制执行，即调用join方法的线程先执行完毕，再执行其他线程。
public class TestThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了 --- " + i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        // 启动我们创建的线程
        TestThread test = new TestThread();
        Thread thread = new Thread(test);
        // 查看线程状态
        Thread.State state = thread.getState();
        // thread.start(); 如果放在这里，main 线程和 thread 会交替进行
        // 主线程
        for (int i = 0; i < 100 ; i++) {
            if (i == 50) {
                // thread.start(); 放在这里， main线程开始执行， start 之后，join 会出现thread先执行完，再执行main
                thread.join(); //线程插队
            }
            System.out.println("主线程执行中 --- " + i);
        }
    }
}
