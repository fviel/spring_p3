/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.spring1.bootstrap;

import com.fernando.spring1.model.Author;
import com.fernando.spring1.model.Book;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


/**
 *
 * @author Fernando
 */
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    
      @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
       //ainda não entendi bem pq do application listener, não sei o que é, mas erstou com sono e vou dormir, depois vejo....
       initData();
    }
    
    private void initData(){
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        
        //Rod
        Author rod = new Author("Rod", "Jonhson");
        Book noEJB = new Book("J2EE Development without EJB", "1235", "Worx");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
    }

  
    
}
