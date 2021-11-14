package com.mitocode.projectmitocodeexam.payload.request;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String title;
    private String description;
    private float price;
    private boolean active;
}
