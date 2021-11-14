package com.mitocode.projectmitocodeexam.services;

import java.util.List;

import com.mitocode.projectmitocodeexam.models.Product;
import com.mitocode.projectmitocodeexam.payload.request.ProductCreateRequest;
import com.mitocode.projectmitocodeexam.payload.request.ProductUpdateRequest;

public interface ProductService {
    Product createProduct(ProductCreateRequest productCreateRequest);
    List<Product> getProducts();
    Product updateProduct(ProductUpdateRequest productUpdateRequest);
    boolean deleteProduct(int idProduct);
    Product getOneByIdProduct(int idProduct);
}
