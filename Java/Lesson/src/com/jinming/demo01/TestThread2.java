package com.jinming.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

// 模拟下载图片例子
public class TestThread2 extends Thread {

    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载完成(文件名：" + name + ")");
    }

    public static void main(String[] args) {
        TestThread2 thread2 = new TestThread2("https://seopic.699pic.com/photo/50055/5043.jpg_wh1200.jpg", "wk.jpg");
        thread2.start();
    }
}

class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO 异常， downloader方法出现问题");
        }
    }
}
