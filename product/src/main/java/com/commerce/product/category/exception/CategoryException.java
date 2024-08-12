package com.commerce.product.category.exception;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryException extends RuntimeException {

    private final CategoryExceptionCode code;


}
