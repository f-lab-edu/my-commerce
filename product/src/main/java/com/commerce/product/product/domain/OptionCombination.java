package com.commerce.product.product.domain;

import com.commerce.product.product.dto.CreateOptionCombination;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString
public class OptionCombination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionCombinationId;
    private Integer stock;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

/*
    @Builder.Default
    @OneToMany(mappedBy = "optionCombination", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "option_combination_id")
    private List<OptionCombinationValue> values = new ArrayList<>();
*/

    public static OptionCombination of(CreateOptionCombination.Request request, List<OptionValue> optionValues) {
        List<OptionCombinationValue> optionCombinationValueList = request.getOptionCombinationValues().stream()
                .map(o -> OptionCombinationValue.of(o, optionValues))
                .collect(Collectors.toList());

        return OptionCombination.builder()
                .stock(request.getStock())
                .price(request.getPrice())
//                .values(optionCombinationValueList)
                .build();
    }

    public static OptionCombination of(CreateOptionCombination.Request request) {
        return OptionCombination.builder()
                .stock(request.getStock())
                .price(request.getPrice())
                .build();
    }
}
