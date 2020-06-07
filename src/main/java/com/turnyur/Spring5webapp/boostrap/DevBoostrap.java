/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turnyur.Spring5webapp.boostrap;

import com.turnyur.Spring5webapp.Models.Author;
import com.turnyur.Spring5webapp.Models.Book;
import com.turnyur.Spring5webapp.Models.Publisher;
import com.turnyur.Spring5webapp.Repositories.AuthorRepository;
import com.turnyur.Spring5webapp.Repositories.BookRepository;
import com.turnyur.Spring5webapp.Repositories.PublisherRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author turnyur
 */
@Component
public class DevBoostrap implements ApplicationListener<ContextRefreshedEvent>{
    AuthorRepository authorRepository;
    BookRepository bookRepository;
    PublisherRepository publisherRepository;
    
    public DevBoostrap(AuthorRepository authorRepository, BookRepository bookRepository, 
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
         this.publisherRepository = publisherRepository;
    }
    
    
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        
        initData();
    
    }

    private void initData() {
        Set<Book> author1Books = new HashSet<>();
        Set<Book> author2Books = new HashSet<>();
        
        
        Set<Author> book1AuthorList = new HashSet<>();
        Set<Author> book2AuthorList = new HashSet<>();
        Set<Author> book3AuthorList = new HashSet<>();
        
        Author author1 = new Author("Williams", "Turnyur");
        Author author2 = new Author("Chukwudi", "Umah");
        Publisher pu = new Publisher();
        pu.setName("Knightingal3");
        pu.setAddress("Ikoyi Lagos");
        publisherRepository.save(pu);
        
        
        Publisher britishPress = new Publisher();
        britishPress.setName("British Press");
        britishPress.setAddress("Uyo, Akwa Ibom");
        publisherRepository.save(britishPress);
    
        book1AuthorList.add(author1);
        book1AuthorList.add(author2);
        
        book2AuthorList.add(author1);
        book2AuthorList.add(author2);
        
        book3AuthorList.add(author2);
       
         
        Book book1 = new Book("Penguin Random House", "677674", pu);
        Book book2 = new Book("Silly IDE Netbean", "isbn", pu);
        //Book book2 = new Book("Domain Driven Designs", "22343585", britishPress,book2AuthorList);
        Book book3 = new Book("Object Oriented Design Patterns", "8953", britishPress);
        //Book book3 = new Book("Object Oriented Design Patterns", "8953", britishPress);
        
        //Commit first AUthor to DB
        author1Books.add(book1);
        author1Books.add(book2);
        author1.setBooks(author1Books);
        authorRepository.save(author1);
        
        //Commit second author to DB
        author2Books.add(book3);
        author2Books.add(book1);
        author2.setBooks(author2Books);
        authorRepository.save(author2);
        
        book1.setAuthors(book1AuthorList);
       //book3.setAuthors(book3AuthorList);
        
        
        //Commit Books to DB
        bookRepository.save(book1);
       // bookRepository.save(book2);
       // bookRepository.save(book3);
   }
    
}
