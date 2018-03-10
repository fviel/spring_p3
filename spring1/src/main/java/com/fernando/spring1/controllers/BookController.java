/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.spring1.controllers;

import com.fernando.spring1.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Fernando
 */
@Controller
public class BookController {

    //não preciso fazer o @Autowired, pois sendo um atributo dentro de uma @Controller, o spring vai fazer o autowire automaticamente
    private BookRepository bookRepository;

    /***
     * A construtora apenas resolve o repositório
     * @param bookrepository 
     */
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    //Model representa a minha entidade Model: Book
    public String getBooks(Model model) {
        
        /*
        Adidiocna um atributo à model existente, chamado books
        Este atributo é na realidade uma lista de books, pois é o return do findAll da minha repository
        */
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }

}
