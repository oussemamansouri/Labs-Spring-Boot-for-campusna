package com.example.onlinestore.dao.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "products")
public class Product {

        // @Column(name = "code",length = 255,nullable = true , unique = false, insertable=true,updatable = true  )

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "code",length = 50,nullable = false , unique = true )
    private String code ;

    @Column(name = "name",length = 30,nullable = false)
    private String name ;

    @Column(name = "price",length = 30,nullable = false)
    private Double price ;

    @Column(name = "quantity",length = 30,nullable = false)
    private int quantity ;

    @Column(name = "image",nullable = true)
    private String image ;



}
