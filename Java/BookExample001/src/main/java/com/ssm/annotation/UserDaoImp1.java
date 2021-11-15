package com.ssm.annotation;

import org.springframework.stereotype.Repository;

// 使用@Repository注解将UserDaoImp1 类标识为Spring中的Bean
@Repository("userDao")
public class UserDaoImp1 implements UserDao {

    @Override
    public void save() {
        System.out.println("userDao.save()");
    }
}
