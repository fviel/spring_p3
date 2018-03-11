package com.fernando;

import com.fernando.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        //joga o resultado da execução para o applicationContext do spring para poder trabalhar ele
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        //obtém o bean do meu controller que já estava no application context
        //atenção para o nome do bean! Exemplo, se fosse FernandoControler, use getBean("fernandoController")
        MyController controller = (MyController) ctx.getBean("myController");
        
        //chama o método hello do bean
        controller.hello();
    }
}
