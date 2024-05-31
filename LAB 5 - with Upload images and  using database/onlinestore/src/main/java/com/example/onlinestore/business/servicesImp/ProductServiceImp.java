package com.example.onlinestore.business.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinestore.business.services.ProductService;
import com.example.onlinestore.dao.entities.Product;
import com.example.onlinestore.dao.repositories.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository ;

    //OR
    // final ProductRepository productRepository ;
    // public ProductServiceImp(ProductRepository productRepository ){
    //     this.productRepository= productRepository;
    // }

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById( Long id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public Product addProduct(Product product) {
       return this.productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
       return this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
      this.productRepository.deleteById(id);
    }

}
