/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_relationship.service;

import com.mycompany.pr31_jv37_spring_mvc_relationship.entities.CategoryEntity;
import com.mycompany.pr31_jv37_spring_mvc_relationship.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> getCategories() {
        return (List<CategoryEntity>) categoryRepository.findAll();
    }
}
