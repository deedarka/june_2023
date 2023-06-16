package com.snva.fashionecommerce.Controller;


import com.snva.fashionecommerce.entities.Product;
import com.snva.fashionecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product saveProduct=productService.createProduct(product);
        return  new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public  ResponseEntity<Product> getProductById(@PathVariable("Id") Integer productId ){
        Product product=productService.getProductById(productId);
        return  new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product>products=productService.getAllProducts();
        return  new ResponseEntity<>(products,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id")Integer productId,@RequestBody Product product){
        product.setId(productId);
        Product updateProduct=productService.updateProduct(product);
        return  new ResponseEntity<>(updateProduct,HttpStatus.OK);
    }

      @DeleteMapping("{id}")
        public  ResponseEntity<String> deleteProduct(@PathVariable("id") Integer productId){
       productService.deleteProduct(productId);
       return  new ResponseEntity<>("Product Deleted",HttpStatus.OK);
    }

}



    

