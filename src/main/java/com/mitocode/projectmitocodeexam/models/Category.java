package com.mitocode.projectmitocodeexam.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

/*NO SE USA LOOMBOOK POR ERRORES CON INFINTY LOOP EN MANY TO MANY*/

@Table(name = "categories")
@Entity
@ApiModel(description = "Categoria de un producto")
public class Category {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long idCategory;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    Set<Product> products;
    
    @Column(name = "title")
    private String title;

    @Column(name = "active", insertable = false)
    private boolean active;

    @Column(name = "create_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    

    public Category() {
    }

    public Category(String title){
        this.title = title;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    

}
