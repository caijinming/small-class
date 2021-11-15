package com.jinming.demo03;

// 多人抢票
/* 存在的问题
   1. 多人抢到同一张票
   2. 还有抢到 -1
   解决方法
   通过synchronized 关键字生成同步方法。来锁操作的对象
 */

public class TestBuyTicket extends Thread {
    private int ticketNums = 10; // 总票数
    private  boolean flag = true; // 通过标志位控制线程终止
    @Override
    public void run() {
        while (flag) {
            try {
                buyTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // 将买票的方法增加synchronized，变成一个同步方法。来实现线程同步的安全性。 这里锁的对象，就是本身this。
    public synchronized void buyTicket() throws InterruptedException {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "抢到了票" + ticketNums--);
    }

    public static void main(String[] args) {
        TestBuyTicket ticket = new TestBuyTicket();

        new Thread(ticket,"自己").start();
        new Thread(ticket,"黄牛").start();
        new Thread(ticket,"小红").start();
    }
}
