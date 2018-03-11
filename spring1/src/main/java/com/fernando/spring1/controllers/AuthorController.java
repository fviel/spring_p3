/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.spring1.controllers;

import com.fernando.spring1.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Fernando
 */
@Controller
public class AuthorController {
    
    private AuthorRepository authorRepository;
    
    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;        
    }
    
    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";        
    }
}
