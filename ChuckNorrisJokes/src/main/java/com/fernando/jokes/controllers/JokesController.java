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

    //faz o autowired automaticamente na construtora, não preciso declarar @Autowired
    public JokesController(SillyJokesService sjs) {
        this.sjs = sjs;
    }      
    
    //esta é a definição usada no vídeo, mas
    //@RequestMapping({"/",""})
    @RequestMapping("/piadas")
    public String getJokes(Model model){
        //adiciona o valor na model
        model.addAttribute("joke", sjs.getJoke());
        
        //chama a página html a ser exibida
        return "showjokes";
    }
    
}
