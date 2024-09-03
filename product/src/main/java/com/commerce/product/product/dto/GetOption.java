package com.commerce.product.product.dto;

import com.commerce.product.product.domain.Option;
import lombok.*;

import java.util.List;

public class GetOption {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long optionId;
        private String name;

        private List<GetOptionValue.Response> optionValues;

        public static Response from(Option option) {
            Response response = Response.builder()
                    .optionId(option.getOptionId())
                    .name(option.getName())
                    .build();

            List<GetOptionValue.Response> optionValues = option.getOptionValues().stream()
                    .map(v -> GetOptionValue.Response.from(v))
                    .toList();
            response.setOptionValues(optionValues);

            return response;
        }
    }
}
