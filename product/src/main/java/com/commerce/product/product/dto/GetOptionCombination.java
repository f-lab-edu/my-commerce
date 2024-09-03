package com.commerce.product.product.dto;

import com.commerce.product.product.domain.OptionCombination;
import lombok.*;

import java.util.List;

public class GetOptionCombination {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long optionCombinationId;
        private Integer stock;
        private Integer price;

        private List<String> values;

        public static Response from(OptionCombination optionCombination) {
            Response response = Response.builder()
                    .optionCombinationId(optionCombination.getOptionCombinationId())
                    .stock(optionCombination.getStock())
                    .price(optionCombination.getPrice())
                    .build();

            List<String> values = optionCombination.getValues().stream()
                    .map(v -> v.getOptionValue().getOptionValue())
                    .toList();
            response.setValues(values);

            return response;
        }
    }
}
