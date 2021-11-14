package com.mitocode.projectmitocodeexam.repositories;
import com.mitocode.projectmitocodeexam.models.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {

    
}
