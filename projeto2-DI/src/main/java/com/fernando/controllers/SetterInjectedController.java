/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.controllers;

import com.fernando.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Este é um exemplo de DI por setter
 * @author Fernando
 */
@Controller
public class SetterInjectedController {
    
    
    private GreetingService greetingService;
    
    public String sayHello(){
        return greetingService.sayGreeting();        
    }
    
    //neste método é feito o set da dependencia
    @Autowired // avisa para injetar no método
    public void setGreetingService(GreetingService greetingService){
        this.greetingService = greetingService;
    }
    
}
