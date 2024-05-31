package com.example.onlinestore.business.services;

import java.util.List;

import com.example.onlinestore.dao.entities.Product;

public interface ProductService {

    //read operation
    List<Product> getAllProduct();
    Product getProductById( Long id);

    //create operation
    Product addProduct(Product product);

    //update operation
    Product updateProduct(Product product, Long id);

    //delete operation
    void deleteProduct(Long id);

}
