package com.fernando.jokes;

import com.fernando.jokes.testBean.Propriedades;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JokesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokesApplication.class, args);
    }
}
