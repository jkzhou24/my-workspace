package com.zwq.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@EnableConfigServer
@SpringBootApplication
public class SpringcloudconfigserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudconfigserverApplication.class, args);
    }
}
