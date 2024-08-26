package com.commerce.product.product.domain;

import com.commerce.product.product.dto.CreateOption;
import com.commerce.product.product.dto.CreateProduct;
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
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

/*    @Builder.Default
    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OptionValue> optionValues = new ArrayList<>();*/
/*

    public static Option of(CreateOption.Request optionDto, CreateProduct.Request productDto) {
        List<OptionValue> optionValues = optionDto.getOptionValues().stream()
                .map(o -> OptionValue.of(o))
                .collect(Collectors.toList());
        return Option.builder()
                .name(optionDto.getOptionName())
                .optionValues(optionValues)
                .build();
    }
*/

    public static Option of(CreateOption.Request optionDto) {
        return Option.builder()
                .name(optionDto.getOptionName())
                .build();
    }

}
