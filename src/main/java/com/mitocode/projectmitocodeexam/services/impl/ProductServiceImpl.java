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
        return  productRepository.save(new Product(productUpdateRequest.getIdProduct(), productUpdateRequest.getTitle(), 
        productUpdateRequest.getDescription(), productUpdateRequest.getPrice(),productUpdateRequest.getCategories()));
        //return null;
    }

    @Override
    public boolean deleteProduct(long idProduct) {
        try {
            productRepository.deleteById(idProduct);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        
        
    }

    @Override
    public Product getOneByIdProduct(long idProduct) {
        return  productRepository.getOneByIdProduct(idProduct);
    }
    
}
