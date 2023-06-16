package com.snva.fashionecommerce.serviceimpl;

import com.snva.fashionecommerce.Exception.ResourceNotFoundException;
import com.snva.fashionecommerce.entities.Product;
import com.snva.fashionecommerce.repository.ProductRepository;
import com.snva.fashionecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer productId) {
        Optional<Product>optionalProduct=productRepository.findById(productId);
        return optionalProduct.orElseThrow(()->new ResourceNotFoundException("product not availble"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        Product exProduct=productRepository.findById(product.getId()).orElseThrow(()->new ResourceNotFoundException("Prduct is not exiting in list"));
        if(exProduct!=null){
            exProduct.setName(product.getName());
            exProduct.setDetails(product.getDetails());
            exProduct.setCategory(product.getCategory());
            exProduct.setImage(product.getImage());
            return  productRepository.save(exProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer productId)
    {
        productRepository.deleteById(productId);

    }
}
