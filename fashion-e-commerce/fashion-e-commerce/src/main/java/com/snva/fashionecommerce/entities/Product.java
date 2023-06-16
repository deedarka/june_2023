package com.snva.fashionecommerce.entities;

import jakarta.persistence.*;
import jdk.jfr.Category;

import java.awt.*;

//Product name (required, maximum length: 100 characters)
//        Product description (optional, maximum length: 500 characters)
//        Product price (required, positive decimal number)
//        Product category (required, maximum length: 50 characters)
//        Product image URL (optional, valid URL format)
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false,length = 500)
    private String  details;
    @Column(nullable = false,length = 50)
    private Category category;
    @Column(length = 340)
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
