package com.commerce.product.product.dto;


import com.commerce.product.product.domain.Product;
import lombok.*;

import java.util.List;

public class GetProduct {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long productId;
        private Long categoryId;
        private String name;
        private String description;

        private List<GetOption.Response> options;
        private List<GetOptionCombination.Response> optionCombinations;
        private List<String> images;

        public static Response from(Product product) {
            Response response = Response.builder()
                    .productId(product.getProductId())
                    .categoryId(product.getCategoryId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .build();

            List<GetOption.Response> options = product.getOptions().stream()
                    .map(o -> GetOption.Response.from(o))
                    .toList();

            List<GetOptionCombination.Response> combinations = product.getOptionCombinations().stream()
                    .map(o -> GetOptionCombination.Response.from(o))
                    .toList();

            List<String> images = product.getImages().stream()
                    .map(i -> i.getImageFileUrl())
                    .toList();

            response.setOptions(options);
            response.setOptionCombinations(combinations);
            response.setImages(images);

            return response;
        }
    }
}
