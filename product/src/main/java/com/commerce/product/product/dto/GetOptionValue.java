package com.commerce.product.product.dto;

import com.commerce.product.product.domain.OptionValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class GetOptionValue {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long optionValueId;
        private String value;

        public static Response from(OptionValue optionValue) {
            return Response.builder()
                    .optionValueId(optionValue.getOptionValueId())
                    .value(optionValue.getOptionValue())
                    .build();
        }
    }
}
