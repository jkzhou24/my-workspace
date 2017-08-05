package com.zwq.springBootDemo;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class App {

    @RequestMapping("/{name}/{age}")
    String home(@PathVariable String name, @PathVariable String age, HttpSession session) {
    	System.out.println(session.getId());
        return "Welcome!" + name + age;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
