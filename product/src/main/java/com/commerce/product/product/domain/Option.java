package com.commerce.product.product.domain;

import com.commerce.product.product.dto.CreateOption;
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
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;
    private String name;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "option_id", nullable = false, updatable = false)
    private List<OptionValue> optionValues = new ArrayList<>();

    public void addOptionValue(OptionValue optionValue) {
        optionValues.add(optionValue);
    }

    public static Option of(CreateOption.Request optionDto) {
        Option option = Option.builder()
                .name(optionDto.getOptionName())
                .build();

        optionDto.getOptionValues()
                .forEach(o -> option.addOptionValue(OptionValue.of(o)));

        return option;
    }
}
