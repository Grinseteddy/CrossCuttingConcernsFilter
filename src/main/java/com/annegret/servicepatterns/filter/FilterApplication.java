package com.annegret.servicepatterns.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilterApplication {

    @Value("${index:1}")
    private int index;

    public static void main(String[] args) {
        SpringApplication.run(FilterApplication.class, args);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
