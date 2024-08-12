package com.commerce.product.product.domain;

import jakarta.persistence.*;

@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String optionValue; // 구분자 ,로 구분
    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product product;
}
