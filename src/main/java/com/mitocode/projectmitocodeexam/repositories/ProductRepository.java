package com.mitocode.projectmitocodeexam.repositories;

import com.mitocode.projectmitocodeexam.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
    
}
