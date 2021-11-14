package com.mitocode.projectmitocodeexam.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "categories")
@Entity
@NoArgsConstructor
public class Category {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int idCategory;

    @ManyToMany(mappedBy = "categories")
    Set<Product> products;
    
    @Column(name = "title")
    private String title;

    @Column(name = "active")
    private boolean active;

    @Column(name = "create_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    public Category(String title){
        this.title = title;
        this.active = true;
    }

}
