/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jokes.services;

import com.fernando.jokes.entities.Joke;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("en_US")
@Primary
public class SillyJokesServiceImpl implements SillyJokesService {
    
    //sendo final, após instanciada, não mais será alterada
    private final ChuckNorrisQuotes cnq;
    
    public SillyJokesServiceImpl(){
        cnq = new ChuckNorrisQuotes();
    }    

    @Override
    public String getJoke() {        
        return cnq.getRandomQuote();
    }
    
}
