/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.spring1.controllers;

import com.fernando.spring1.repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Fernando
 */

@Controller
public class PublisherController {
    private PublisherRepository publisherRepository;    
    
    public PublisherController(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }    
    
    @RequestMapping("/publishers")
    public String getPublishers(Model model){
        
        //faz a pesquisa no bd e anexa o resultado no objeto model
        model.addAttribute("publishers", publisherRepository.findAll());
        
        //chama a página html para exibvição de publishers
        return "publishers";
    }
    
    
    
}
