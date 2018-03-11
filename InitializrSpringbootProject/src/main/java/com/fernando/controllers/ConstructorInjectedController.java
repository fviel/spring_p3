/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.controllers;

import com.fernando.services.GreetingService;

/**
 *
 * @author Fernando
 */
public class ConstructorInjectedController {
    
     private GreetingService greetingService;

    //neste método é feito o set da dependencia, ou seja na construtora
    public ConstructorInjectedController(GreetingService greetingService){
        this.greetingService = greetingService;
    }
    
    public String sayHello(){
        return greetingService.sayGreeting();        
    }
    
    
   
}
