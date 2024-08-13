package com.commerce.product.product.exception;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductException extends RuntimeException {

    private final ProductExceptionCode code;


}
