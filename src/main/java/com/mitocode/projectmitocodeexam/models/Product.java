package com.mitocode.projectmitocodeexam.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/*NO SE USA LOOMBOOK POR ERRORES CON INFINTY LOOP EN MANY TO MANY*/

@Table(name = "products")
@Entity
public class Product {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long idProduct;

    @ManyToMany(fetch = FetchType.LAZY)
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

    @Column(name = "active", insertable = false)
    private boolean active;

    @Column(name = "create_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    public Product(String title, String description, float price, Set<Category> categories){
      this.title=title;
      this.description=description;
      this.price=price;
      this.categories=categories;
    }

    public Product(long idProduct, String title, String description, float price, Set<Category> categories){
      this.idProduct=idProduct;
      this.title=title;
      this.description=description;
      this.price=price;
      this.categories=categories;
    }

    

    public Product() {
    }



    public long getIdProduct() {
      return idProduct;
    }

    public void setIdProduct(int idProduct) {
      this.idProduct = idProduct;
    }

    public Set<Category> getCategories() {
      return categories;
    }

    public void setCategories(Set<Category> categories) {
      this.categories = categories;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public float getPrice() {
      return price;
    }

    public void setPrice(float price) {
      this.price = price;
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
