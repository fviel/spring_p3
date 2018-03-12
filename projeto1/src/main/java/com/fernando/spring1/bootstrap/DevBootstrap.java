/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.spring1.bootstrap;

import com.fernando.spring1.model.Author;
import com.fernando.spring1.model.Book;
import com.fernando.spring1.model.Publisher;
import com.fernando.spring1.repositories.AuthorRepository;
import com.fernando.spring1.repositories.BookRepository;
import com.fernando.spring1.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 *
 * @author Fernando
 */
@Component //transforma em spring bean
//ApplicationListener<ContextRefreshedEvent> é um dos eventos padrões do spring, ainda não entendi direito, mas vou ver
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }   
    
      @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
       //ainda não entendi bem pq do application listener, não sei o que é, mas estou com sono e vou dormir, depois vejo....
       initData();
    }
    
    private void initData(){
        Publisher pb = new Publisher("Fernando", "www.fernando.com");
        
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", pb);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        
        publisherRepository.save(pb);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        
        
        
        //Rod
        Author rod = new Author("Rod", "Jonhson");
        Book noEJB = new Book("J2EE Development without EJB", "1235", pb);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        
        publisherRepository.save(pb);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        
        
    }

  
    
}
