package com.commerce.product.product.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductExceptionCode {

    NOT_FOUND_PRODUCT("P001", "상품을 찾지 못하였습니다.");

    private final String code;
    private final String message;
}
