/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turnyur.Spring5webapp.Repositories;

import com.turnyur.Spring5webapp.Models.Author;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author turnyur
 */
public interface AuthorRepository extends CrudRepository<Author, Long>{
    
}
