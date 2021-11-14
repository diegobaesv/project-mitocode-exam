package com.mitocode.projectmitocodeexam.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "products")
@Entity
@NoArgsConstructor
public class Product {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduct;

    @ManyToMany
    @JoinTable(
      name = "product_category", 
      joinColumns = @JoinColumn(name = "id_product"), 
      inverseJoinColumns = @JoinColumn(name = "id_category"))
    private Set<Category> categories;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @Column(name = "active")
    private boolean active;

    @Column(name = "create_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

}
