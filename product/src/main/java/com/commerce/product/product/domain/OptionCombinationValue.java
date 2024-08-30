package com.commerce.product.product.domain;

import com.commerce.product.product.exception.ProductException;
import com.commerce.product.product.exception.ProductExceptionCode;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

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
    @JoinColumn(name = "option_combination_id")
    private OptionCombination optionCombination;

    @ManyToOne
    @JoinColumn(name = "option_value_id")
    private OptionValue optionValue;

    public static OptionCombinationValue of(String value, List<OptionValue> optionValues) {
        OptionValue savedOptionValue = getOptionValue(value, optionValues);

        if (Objects.isNull(savedOptionValue)) {
            throw new ProductException(ProductExceptionCode.NOT_MATCHED_OPTION_VALUE);
        }

        return OptionCombinationValue.builder()
                .optionValue(savedOptionValue)
                .build();
    }

    public static OptionCombinationValue of(OptionCombination optionCombination, OptionValue optionValue) {
        return OptionCombinationValue.builder()
                .optionCombination(optionCombination)
                .optionValue(optionValue)
                .build();
    }

    private static OptionValue getOptionValue(String value, List<OptionValue> optionValues) {
        for (OptionValue optionValue : optionValues) {
            if (optionValue.isOptionValue(value)) {
                return optionValue;
            }
        }

        return null;
    }
}