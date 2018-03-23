/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jokes.config;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Esta classe faz a configuração do spring via código java
 * @author Fernando
 */
@Configuration
public class ChuckConfig {
    
    /*
    No exemplo abaixo, observe que na SillyJokesServiceImpl()  eu estava antes
    fazendo o new do objeto ChuckNorrisQuotes.
    Então, a contrutora da classe foi alterada e configurei abaixo um
    Bean do spring, e nele fiz o new do objeto, portanto agora
    basta fazer o @Autowired dele no código, ao invés do new e o objeto
    será gerenciado pelo spring.
    */
    @Bean // define que o ChuckNorrisQuotes é um bean spring
    public ChuckNorrisQuotes cnq(){
        return new ChuckNorrisQuotes();
    }
    
}
