package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")  // 处理对根路径的请求
    public String home() {
        return "home"; // 返回视图名
    }
}
