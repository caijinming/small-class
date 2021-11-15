package com.jinming.com.obj;

import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClassFive {

    // 异常处理
    void process() {
        try {
            process1();
        } catch (Exception e) {
            // 打印异常
            e.printStackTrace();
        }
    }

    void process1() {
        try {
            process2();
        } catch (NullPointerException e) {
            throw  new IllegalArgumentException();
        } finally {
            // 无论是否捕获到异常，这个语句都在最后被执行。
        }
    }
    void process2() {
        throw new NullPointerException();
    }


    // 日志的使用
    void logOne() {
        // 系统日志
        Logger logger = Logger.getGlobal();
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("igned");
        logger.severe("process will be terminated...");
        /*
        注意： 日志的输出可以设置级别。JDK的Logging定义了7个日志级别，从严重到普通：SEVERE；WARNING；INFO；CONFIG；FINE；FINER；FINEST
        默认级别是info。 因此info级别以下的日志，不会被打印处理。
        Logging系统在JVM启动时读取配置文件并完成初始化，一旦开始运行main()方法，就无法修改配置；
        配置不太方便，需要在JVM启动时传递参数-Djava.util.logging.config.file=<config-file-name>。
        * **/
    }

    // Commons Logging :Commons Logging的特色是，它可以挂接不同的日志系统，并通过配置文件指定挂接的日志系统。默认情况下，Commons Loggin自动搜索并使用Log4j（Log4j是另一个流行的日志系统），如果没有找到Log4j，再使用JDK Logging。
    static final  Log log = LogFactory.getLog(ClassFive.class);
    static void  foo() {
        log.info("foo");
    }

    // 实例方法用log
    protected final  Log llog = LogFactory.getLog(getClass());
    // getClass 有个非常大的好处，就是子类可以直接使用该log实例
    void ffoo() {
        log.info("ffoo");
    }

}
