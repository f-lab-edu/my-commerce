package com.commerce.product.product.dto;

import com.commerce.product.product.domain.OptionCombinationValue;
import lombok.*;

public class GetOptionCombinationValue {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long optionCombinationValueId;
        private String optionValue;


        public static Response from(OptionCombinationValue combinationValue) {
            return Response.builder()
                    .optionCombinationValueId(combinationValue.getOptionCombinationValueId())
                    .optionValue(combinationValue.getOptionValue().getOptionValue())
                    .build();
        }
    }
}
