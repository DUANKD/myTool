package com.mytool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * @author duankaida@bigo.sg
 * @since 2022年06月10日 下午 3:40
 */
@SpringBootApplication
public class MyToolApplication {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(MyToolApplication.class, args);
    }
}
