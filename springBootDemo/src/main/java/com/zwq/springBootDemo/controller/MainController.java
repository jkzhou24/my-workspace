package com.zwq.springBootDemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

//@RestController = @Controller + @ResponseBody 默认直接返回json
@RestController
public class MainController {

    @RequestMapping("/{name}/{age}")
    String welcome(@PathVariable String name, @PathVariable String age, HttpSession session) {
        System.out.println("sessionId:" + session.getId());
        return "Welcome!" + name + age;
    }

}


