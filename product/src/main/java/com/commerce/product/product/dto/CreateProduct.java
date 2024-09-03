package com.commerce.product.product.dto;

import com.commerce.product.product.domain.Product;
import lombok.*;

import java.util.List;

public class CreateProduct {

    @Getter
    @ToString
    public static class Request {
        private String productName;
        private Long categoryId;
        private String description;

        private List<CreateOption.Request> options;
        private List<CreateOptionCombination.Request> optionCombinations;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String name;

        public static Response from(Product product) {
            return Response.builder()
                    .name(product.getName())
                    .build();
        }
    }
}
