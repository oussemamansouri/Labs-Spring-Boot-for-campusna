package com.example.onlinestore.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinestore.dao.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
