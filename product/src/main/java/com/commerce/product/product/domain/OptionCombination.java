package com.commerce.product.product.domain;

import com.commerce.product.product.dto.CreateOptionCombination;
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
public class OptionCombination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionCombinationId;
    private Integer stock;
    private Integer price;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "option_combination_id", nullable = false, updatable = false)
    private List<OptionCombinationValue> values = new ArrayList<>();

    public void addOptionCombinationValue(OptionCombinationValue combinationValue) {
        values.add(combinationValue);
    }

    public static OptionCombination of(CreateOptionCombination.Request combinationDto, List<OptionValue> optionValues) {
        OptionCombination optionCombination = OptionCombination.builder()
                .stock(combinationDto.getStock())
                .price(combinationDto.getPrice()).build();

        combinationDto.getOptionCombinationValues()
                .forEach(v -> optionCombination.addOptionCombinationValue(OptionCombinationValue.of(v, optionValues)));

        return optionCombination;
    }
}
