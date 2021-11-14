package com.mitocode.projectmitocodeexam.controllers;

import java.util.List;

import com.mitocode.projectmitocodeexam.exceptions.InternalServerException;
import com.mitocode.projectmitocodeexam.exceptions.NotFoundException;
import com.mitocode.projectmitocodeexam.models.Category;
import com.mitocode.projectmitocodeexam.payload.request.CategoryCreateRequest;
import com.mitocode.projectmitocodeexam.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryCreateRequest categoryCreateRequest){
        Category category=null;
        try {
            category = categoryService.createCategory(categoryCreateRequest);   
        } catch (Exception e) {
            throw new InternalServerException();
        }

        if(category==null) throw new InternalServerException();

        return new ResponseEntity<Category>(category,HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAll(){
        List<Category> list;
        try{
            list = categoryService.getCategories();
        }catch(Exception e){
            throw new InternalServerException();
        }

        if(list == null) throw new NotFoundException();

        return new ResponseEntity<List<Category>>(list,HttpStatus.OK);
    }

}
