package com.commerce.product.category.dto;

import com.commerce.product.category.domain.Category;
import lombok.*;

public class CreateCategory {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private long parentCategoryId;
        private String name;
        private Double feeRate;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long categoryId;

        public static Response from(Category category) {
            return Response.builder()
                    .categoryId(category.getId())
                    .build();
        }
    }
}
