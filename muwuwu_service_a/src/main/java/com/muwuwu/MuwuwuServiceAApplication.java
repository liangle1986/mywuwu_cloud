package com.muwuwu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MuwuwuServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuwuwuServiceAApplication.class, args);
    }
}
