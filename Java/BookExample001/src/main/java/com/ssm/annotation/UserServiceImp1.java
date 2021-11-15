package com.ssm.annotation;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImp1 implements UserService {
    @Resource(name="userDao")
    private UserDao userDao;
    @Override
    public void save() {
        this.userDao.save();
        System.out.println("执行userService.save()");
    }
}
