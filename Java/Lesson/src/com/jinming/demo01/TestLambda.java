package com.jinming.demo01;

// lambda 表达式的演进

public class TestLambda {
    // 2. 静态内部类
    static class Like1 implements ILike {
        @Override
        public void lambda() {
            System.out.println("i like lambda 2");
        }
    }

    public static void main(String[] args) {

        ILike like = new Like();
        like.lambda();

        like = new Like1();
        like.lambda();

        // 3. 局部内部类
        class Like2 implements ILike {
            @Override
            public void lambda() {
                System.out.println("i like lambda 3");
            }
        }

        like = new Like();
        like.lambda();

        // 4. 匿名内部类. 没有类名，需要借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda 4");
            }
        };

        // 5. lambda 表达式。 取消上面的new 接口名或者类名，方法名
        like = () -> {
            System.out.println("i like lambda 5");
        };

        // 带参数的演示
        ILikeParams kp = null;
        kp = (a) -> {
            System.out.println("lambda 带参数: " + a);
        };
        kp = a -> {
            System.out.println("lambda 带参数: " + a);
        };
        kp = a -> System.out.println("lambda 带参数: " + a);
    }
}

interface ILike {
    void lambda();
}

interface ILikeParams {
    void lambdap(int a);
}

// 1. 类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}