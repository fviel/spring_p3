package com.fernando.jokes.controllers;

import com.fernando.jokes.services.SillyJokesService;
import com.fernando.jokes.testBean.Propriedades;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
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
    Propriedades p;

    //faz o autowired automaticamente na construtora, não preciso declarar @Autowired
    public JokesController(SillyJokesService sjs, Propriedades p) {
        this.sjs = sjs;
        this.p = p;
    }      
    
    //esta é a definição usada no vídeo, mas
    //@RequestMapping({"/",""})
    @RequestMapping("/piadas")
    public String getJokes(Model model){                     
        
        //adiciona o valor na model
        model.addAttribute("joke", sjs.getJoke());
        model.addAttribute("headTitle", p.getPageHeadTitle());
        model.addAttribute("title", p.getPageTitle());
        
        //chama a página html a ser exibida
        return "showjokes";
    }
    
}
