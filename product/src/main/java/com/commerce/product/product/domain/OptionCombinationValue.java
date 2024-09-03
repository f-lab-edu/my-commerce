package com.commerce.product.product.domain;

import com.commerce.product.product.exception.ProductException;
import com.commerce.product.product.exception.ProductExceptionCode;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OptionCombinationValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionCombinationValueId;

    @ManyToOne
    @JoinColumn(name = "option_value_id", nullable = false)
    private OptionValue optionValue;

    public static OptionCombinationValue of(String value, List<OptionValue> optionValues) {
        OptionValue optionValue = getOptionValue(value, optionValues);
        return OptionCombinationValue.builder()
                .optionValue(optionValue).build();
    }

    private static OptionValue getOptionValue(String value, List<OptionValue> optionValues) {
        for (OptionValue optionValue : optionValues) {
            if (optionValue.getOptionValue().equals(value)) {
                return optionValue;
            }
        }

        throw new ProductException(ProductExceptionCode.OPTION_VALUE_NOT_MATCHED);
    }
}