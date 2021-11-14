package com.mitocode.projectmitocodeexam.services.impl;

import java.util.List;

import com.mitocode.projectmitocodeexam.models.Product;
import com.mitocode.projectmitocodeexam.payload.request.ProductCreateRequest;
import com.mitocode.projectmitocodeexam.payload.request.ProductUpdateRequest;
import com.mitocode.projectmitocodeexam.repositories.ProductRepository;
import com.mitocode.projectmitocodeexam.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(ProductCreateRequest productCreateRequest) {
        return  productRepository.save(new Product(productCreateRequest.getTitle(), 
        productCreateRequest.getDescription(), productCreateRequest.getPrice(),productCreateRequest.getCategories()));
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(ProductUpdateRequest productUpdateRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteProduct(int idProduct) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Product getOneByIdProduct(int idProduct) {
        return  productRepository.getOneByIdProduct(idProduct);
    }
    
}
