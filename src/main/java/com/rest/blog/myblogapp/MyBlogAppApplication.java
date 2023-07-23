package com.rest.blog.myblogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class MyBlogAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBlogAppApplication.class, args);
    }

}
