/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turnyur.Spring5webapp.Controllers;

import com.turnyur.Spring5webapp.Repositories.BookRepository;
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
public class BookController {
    BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    
    
    @RequestMapping("/books")
    public String handleBookPath(Model model){
        Map bookMap = new HashMap();
        bookMap.put("books", bookRepository.findAll());
        model.addAllAttributes(bookMap);
        
        return "books";
    }
    
    
}
