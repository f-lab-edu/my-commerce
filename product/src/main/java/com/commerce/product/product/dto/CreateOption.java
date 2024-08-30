package com.commerce.product.product.dto;

import com.commerce.product.product.domain.Product;
import lombok.*;

import java.util.List;

public class CreateOption {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Request {
        private String optionName;

        private List<CreateOptionValue.Request> optionValues;
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
