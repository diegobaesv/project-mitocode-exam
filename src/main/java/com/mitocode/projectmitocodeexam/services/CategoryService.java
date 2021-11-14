package com.mitocode.projectmitocodeexam.services;

import java.util.List;

import com.mitocode.projectmitocodeexam.models.Category;
import com.mitocode.projectmitocodeexam.payload.request.CategoryCreateRequest;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Category createCategory(CategoryCreateRequest categoryCreateRequest);
    List<Category> getCategories();
}
