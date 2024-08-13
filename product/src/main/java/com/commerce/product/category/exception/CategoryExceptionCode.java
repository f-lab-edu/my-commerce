package com.commerce.product.category.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CategoryExceptionCode {

    NOT_FOUND_CATEGORY("C001", "카테고리를 찾지 못하였습니다.");

    private final String code;
    private final String message;
}
