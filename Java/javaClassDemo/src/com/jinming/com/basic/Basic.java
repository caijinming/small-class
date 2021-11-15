package com.jinming.com.basic;

import java.util.Arrays;

public class Basic {
    public  void testOne() {
        int[] s = {1, 10, 20, 40};

        // 循环
        for (int i = 0; i < s.length; i ++) {
            int n = s[i];
            System.out.println(n);
        }
        // 循化 for each
        for (int n : s) {
            System.out.println(n);
        }
        // 循环 array string
        System.out.println(Arrays.toString(s));

    }
}
