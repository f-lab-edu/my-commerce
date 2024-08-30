package com.commerce.product.product.exception;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum ProductExceptionCode {

    NOT_FOUND_PRODUCT("P001", "상품을 찾지 못하였습니다."),
    DUPLICATED_PRODUCT_NAME("P002", "같은 이름의 상품이 존재합니다."),
    NOT_MATCHED_OPTION_VALUE("O", "일치하는 옵션값이 없습니다.");

    private final String code;
    private final String message;
}
