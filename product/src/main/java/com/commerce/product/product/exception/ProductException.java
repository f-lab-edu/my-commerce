package com.commerce.product.product.exception;


import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class ProductException extends RuntimeException {

    private final ProductExceptionCode code;


}
