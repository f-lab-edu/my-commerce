package com.commerce.product.product.dto;

import com.commerce.product.product.domain.Product;
import lombok.*;

import java.util.List;

public class CreateProduct {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Request {
        private String productName;
        private Long categoryId;
        private String description;

        private List<CreateOption.Request> options;
        private List<CreateOptionCombination.Request> optionCombinations;

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
