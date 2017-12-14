package com.example.spring.jsp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author yuweijun 2017-12-07
 */
@SpringBootApplication
public class SpringBootInfoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootInfoApplication.class).run(args);
    }

}
