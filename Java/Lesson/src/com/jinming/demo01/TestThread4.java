package com.jinming.demo01;

// 模拟抢票
public class TestThread4 implements Runnable{
    private int ticket = 10;

    @Override
    public void run() {
        while (true) {
            if (ticket <= 0) break;

            // 模拟抢票延迟
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "抢到了第" + ticket-- + "张票");
        }
    }

    public static void main(String[] args) {
        // 识别并发，二个人抢到同一张票
        TestThread4 thread4 = new TestThread4();

        new Thread(thread4, "小明").start();
        new Thread(thread4, "小红").start();
        new Thread(thread4, "黄牛").start();
    }
}
