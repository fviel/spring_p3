package com.fernando.jokes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Fernando
 */
@Controller
public class JokesController {
    
    @RequestMapping("/piadas")
    public String getJokes(Model model){
        model.addAttribute("jokes", model);
        
        return "shojokes";
    }
    
}
