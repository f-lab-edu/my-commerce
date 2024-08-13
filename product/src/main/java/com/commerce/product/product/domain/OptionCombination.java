package com.commerce.product.product.domain;

import jakarta.persistence.*;

@Entity
public class OptionCombination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String optionValue;
    private Long stock;
    private String price;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
