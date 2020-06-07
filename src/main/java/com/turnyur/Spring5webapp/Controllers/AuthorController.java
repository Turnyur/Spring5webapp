/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turnyur.Spring5webapp.Controllers;

import com.turnyur.Spring5webapp.Repositories.AuthorRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author turnyur
 */
@Controller
public class AuthorController {
    
    AuthorRepository ar;

    public AuthorController(AuthorRepository ar) {
        this.ar = ar;
    }
    
    
    @RequestMapping("/authors")
    public String handleAuthors(Model model){
        
        Map authorMap = new HashMap();
        authorMap.put("authors", ar.findAll());
        model.addAllAttributes(authorMap);
        return "authorView";
    }
    
}
