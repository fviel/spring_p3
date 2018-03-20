package com.fernando.jokes.controllers;

import com.fernando.jokes.services.SillyJokesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Fernando
 */
@Controller
public class JokesController {
    
    SillyJokesService sjs;

    //faz o autowired na construtora
    public JokesController(SillyJokesService sjs) {
        this.sjs = sjs;
    }
    
    
    
    
    
    
    @RequestMapping("/piadas")
    public String getJokes(Model model){
        System.out.println(sjs.getJoke());
        model.addAttribute("joke", sjs.getJoke());
        
        return "showjokes";
    }
    
}
