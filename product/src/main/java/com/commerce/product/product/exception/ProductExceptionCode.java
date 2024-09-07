package com.commerce.product.product.exception;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum ProductExceptionCode {

    // Product
    PRODUCT_NOT_FOUND("P001", "상품을 찾지 못하였습니다."),
    PRODUCT_DUPLICATED_NAME("P002", "같은 이름의 상품이 존재합니다."),

    // Option
    OPTION_VALUE_NOT_MATCHED("O001", "일치하는 옵션값이 없습니다.");

    // OptionCombination

    // OptionCombinationValue

    // ProductImage


    private final String code;
    private final String message;
}
