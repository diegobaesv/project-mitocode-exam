package com.mitocode.projectmitocodeexam.services.impl;

import java.util.List;

import com.mitocode.projectmitocodeexam.models.Category;
import com.mitocode.projectmitocodeexam.payload.request.CategoryCreateRequest;
import com.mitocode.projectmitocodeexam.repositories.CategoryRepository;
import com.mitocode.projectmitocodeexam.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryCreateRequest categoryCreateRequest) {
        return categoryRepository.save(new Category(categoryCreateRequest.getTitle()));
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
    
}
