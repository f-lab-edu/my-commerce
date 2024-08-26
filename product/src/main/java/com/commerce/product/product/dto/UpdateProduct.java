package com.commerce.product.product.dto;

import com.commerce.product.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UpdateProduct {

    @Getter
    public static class Request {
        private String productName;
        private Long categoryId;
        private String description;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class Response {
        public static Response from(Product product) {
            return Response.builder()
                    .build();
        }
    }
}
