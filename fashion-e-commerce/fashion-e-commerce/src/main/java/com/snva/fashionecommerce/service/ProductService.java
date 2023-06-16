package com.snva.fashionecommerce.service;

import com.snva.fashionecommerce.entities.Product;

import java.util.List;

public interface ProductService {


    Product createProduct(Product product);

    Product getProductById(Integer productId);

    List<Product> getAllProducts();

    Product updateProduct(Product product);

    void deleteProduct(Integer productId);
}
