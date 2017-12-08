package com.example.spring.jsp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author yuweijun 2017-12-07
 */
@SpringBootApplication
@ServletComponentScan
public class SpringBootTomcatJspApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootTomcatJspApplication.class).run(args);
    }

}
