package org.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 将类注解成组件
public class Person {
    IAir air;
    @Autowired // 对构造函数进行标注， 将iair类型对象注入person中。
    public Person(@Qualifier("dirtyAir") IAir air) {
        // 具体注入哪个对象，使用Qualifier 关键字进行区分
        this.air = air;
    }

    public void breath() {
        System.out.println(this.air.toString());
    }
}
