/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.controllers;

import org.springframework.stereotype.Controller;

/**
 *
 * @author Fernando
 */
//com @Controller esta classe passa a ser uma entidade gerenciada pelo spring (BEAN) e entra no spring context
@Controller
public class MyController {
    
    public String hello(){
        System.out.println("Olá Fernando!");
        return "foo";       
    }
    
}
