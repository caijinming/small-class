package com.jinming.demo03;

import javafx.css.StyleableIntegerProperty;
import static java.lang.Thread.sleep;

// 解决并发取钱的问题， 通过synchronized块来解决
public class TestDrawMoney  {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");
        Bank bank1 = new Bank(account, 50, "我");
        Bank bank2 = new Bank(account, 100, "媳妇");

        bank1.start();
        bank2.start();
    }
}

// 账户
class Account {
    int money; // 金额
    String name; // 卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 银行： 模拟取钱
class Bank extends Thread {
    Account account; // 账户
    int drawingMoney; // 取了多少钱
    int nowMoney; // 手里的钱

    public Bank(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    // 取钱
    @Override
    public void run() {
        // 同步块，锁取款账户
        synchronized (account) {
            // 判断钱是否够
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够了，不能取款");
                return;
            }

            // 增加延迟放大线程问题
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.money = account.money - drawingMoney;
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + "取完，余额为：" + account.money);
            System.out.println(this.getName() + "手里的钱：" + nowMoney);
        }
    }
}
