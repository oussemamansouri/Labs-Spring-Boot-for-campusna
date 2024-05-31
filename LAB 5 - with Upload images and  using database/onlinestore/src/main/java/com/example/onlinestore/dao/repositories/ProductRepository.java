package com.example.onlinestore.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinestore.dao.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
