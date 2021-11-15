package com.ssm.annotation;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("UserController")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    public void save() {
        this.userService.save();
        System.out.println("运行userController.save()");
    }
}
