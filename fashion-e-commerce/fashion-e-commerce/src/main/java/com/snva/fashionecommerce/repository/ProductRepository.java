package com.snva.fashionecommerce.repository;

import com.snva.fashionecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer> {

}
