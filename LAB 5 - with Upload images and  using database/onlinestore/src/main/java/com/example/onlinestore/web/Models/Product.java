package com.example.onlinestore.web.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class Product {

    private Long id ;
    private String code ;
    private String name ;
    private Double price ;
    private int quantity ;
    private String image ;

}
