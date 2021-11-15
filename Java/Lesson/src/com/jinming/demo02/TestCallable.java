package com.jinming.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//  Callable 实现线程
public class TestCallable implements Callable<Boolean> {

    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载完成(文件名：" + name + ")");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建目标对象
        TestCallable thread2 = new TestCallable("https://seopic.699pic.com/photo/50055/5043.jpg_wh1200.jpg", "callable.jpg");
        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(1); // 线程池里的线程数
        // 提交执行
        Future<Boolean> s1 = service.submit(thread2);
        // 获取结果
        boolean r1 = s1.get();
        // 关闭服务
        service.shutdownNow();
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
