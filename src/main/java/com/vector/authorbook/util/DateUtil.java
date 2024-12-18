package com.vector.authorbook.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class DateUtil {

    @PostConstruct
    public void postConstruct() {
        System.out.print("hello");
    }


    @PreDestroy
    public void preDestroy() {
        System.out.print("bye bye");
    }
}
