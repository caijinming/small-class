package com.jinming.demo01;

/* 静态代理
1. 需要实现共同的接口
2. 需要传入一个真实的对象。
优点：
    可以帮助真实对象实现其他问题。
    可以使得自己能专注处理自己的问题。
 */

// 注意一个类里只运行有一个public 修饰的类
public class TestThread6 {
    public static void main(String[] args) {
        You you = new You();
        WeddingCompany company = new WeddingCompany(you);
        company.HappyMarry();

        /*
        new Thread().start();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(() -> System.out.println("haha")).start();
        */

        // 可以看出线程的本质也是一个静态代理。
    }
}

interface Marry {
    void HappyMarry();
}

class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("我结婚了");
    }
}

class WeddingCompany implements Marry {
    private Marry target;
    public WeddingCompany(Marry target) {
        this.target = target;
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }
    private void before() {
        System.out.println("帮助布置婚庆内容");
    }

    private void after() {
        System.out.println("付尾款");
    }
}
