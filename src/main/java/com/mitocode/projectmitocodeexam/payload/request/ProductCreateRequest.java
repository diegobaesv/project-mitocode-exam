package com.mitocode.projectmitocodeexam.payload.request;

import java.util.Set;

import com.mitocode.projectmitocodeexam.models.Category;

import lombok.Data;

@Data
public class ProductCreateRequest {
    private String title;
    private String description;
    private float price;
    private Set<Category> categories;
}
