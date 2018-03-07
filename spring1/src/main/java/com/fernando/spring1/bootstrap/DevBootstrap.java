/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.spring1.bootstrap;

import com.fernando.spring1.model.Author;
import com.fernando.spring1.model.Book;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Fernando
 */
public class DevBootstrap {
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
    Set<Book> books = new HashSet<>();
    //eric.setb
    
    
}
