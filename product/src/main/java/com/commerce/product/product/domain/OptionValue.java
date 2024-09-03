package com.commerce.product.product.domain;


import com.commerce.product.product.dto.CreateOptionValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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

    public static OptionValue of(CreateOptionValue.Request optionValueDto) {
        return OptionValue.builder()
                .optionValue(optionValueDto.getOptionValue())
                .build();
    }
}
