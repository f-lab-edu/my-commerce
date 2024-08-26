package com.commerce.product.product.domain;

import com.commerce.product.product.dto.CreateOptionValue;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OptionValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionValueId;

    private String optionValue;

/*    @Builder.Default
    @OneToMany
    private List<OptionCombinationValue> optionCombinationValues = new ArrayList<>();*/

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;

    public boolean isOptionValue(String value) {
        return optionValue.equals(value);
    }

    public static OptionValue of(CreateOptionValue.Request optionValueDto) {
        return OptionValue.builder()
                .optionValue(optionValueDto.getOptionValue())
                .build();
    }
}
