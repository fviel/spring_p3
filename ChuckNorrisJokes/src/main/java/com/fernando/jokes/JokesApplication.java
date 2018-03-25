package com.fernando.jokes;

import com.fernando.jokes.testBean.Propriedades;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JokesApplication {

    public static void main(String[] args) {

        //joga o resultado da execução para o applicationContext do spring para poder trabalhar ele
        ApplicationContext ctx = SpringApplication.run(JokesApplication.class, args);
        
         Propriedades p = (Propriedades) ctx.getBean(Propriedades.class);

        SpringApplication.run(JokesApplication.class, args);
    }
}
