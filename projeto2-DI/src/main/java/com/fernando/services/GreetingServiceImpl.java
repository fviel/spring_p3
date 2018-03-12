/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.services;

import org.springframework.stereotype.Service;

//define como um spring bean de service
@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String HELLO_GURUS = "Hello Gurus!";
    
    @Override
    public String sayGreeting() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return HELLO_GURUS;
    }
    
}
