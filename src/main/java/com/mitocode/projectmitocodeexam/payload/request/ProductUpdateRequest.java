package com.mitocode.projectmitocodeexam.payload.request;

import java.util.Set;

import com.mitocode.projectmitocodeexam.models.Category;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private long idProduct;
    private String title;
    private String description;
    private float price;
    private boolean active;
    private Set<Category> categories;
}
