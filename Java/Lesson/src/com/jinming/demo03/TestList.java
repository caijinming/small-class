package com.jinming.demo03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// 这里也会引发线程同步的问题， 导致数组里面数据塞不满。
public class TestList {
    public static void main(String[] args) {
        /*

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10000 ; i++) {
            // lambda 表达式
            synchronized (list) {
                new Thread(()->{
                    list.add(Thread.currentThread().getName());
                }).start();
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count = " + String.format("%d", list.size()));

         */

        // JUC 线程安全的数组
        CopyOnWriteArrayList<String > list = new CopyOnWriteArrayList<String >();
        for (int i = 0; i < 10000 ; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count = " + String.format("%d", list.size()));
    }
}
