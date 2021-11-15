package com.mitocode.projectmitocodeexam.controllers;

import java.util.List;

import com.mitocode.projectmitocodeexam.models.Product;
import com.mitocode.projectmitocodeexam.payload.request.ProductCreateRequest;
import com.mitocode.projectmitocodeexam.payload.request.ProductUpdateRequest;
import com.mitocode.projectmitocodeexam.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value="")
    public ResponseEntity<Product> createCategory(@RequestBody ProductCreateRequest productCreateRequest){
        Product product = productService.createProduct(productCreateRequest);

        return new ResponseEntity<Product>(product,HttpStatus.CREATED);
    }

    @GetMapping(value="")
    public ResponseEntity<List<Product>> getAllCategories(){
        return new ResponseEntity<List<Product>>(productService.getProducts(),HttpStatus.OK);
    }

    @GetMapping(value="/{idProduct}")
    public ResponseEntity<Product> getByIdProduct(@PathVariable long idProduct){
        return new ResponseEntity<Product>(
            productService.getOneByIdProduct(idProduct),HttpStatus.OK);
    }

    @DeleteMapping(value="/{idProduct}")
    public ResponseEntity<Boolean> deleteByIdProduct(@PathVariable long idProduct){
        return new ResponseEntity<Boolean>(
            productService.deleteProduct(idProduct),HttpStatus.OK);
    }

    @PutMapping(value="/{idProduct}")
    public ResponseEntity<Product> updateByIdProduct(@PathVariable long idProduct,@RequestBody ProductUpdateRequest productUpdateRequest){
        productUpdateRequest.setIdProduct(idProduct);
        return new ResponseEntity<Product>(
            productService.updateProduct(productUpdateRequest),HttpStatus.OK);
    }
    
}
