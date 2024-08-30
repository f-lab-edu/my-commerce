package com.commerce.product.product.dto;

import com.commerce.product.product.domain.Option;
import com.commerce.product.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailDto {

    private String productName;
    private String price;


    private List<OptionDto> optionDtoList;

    public static ProductDetailDto from(Product product) {
        return ProductDetailDto.builder()
                .productName(product.getName())
                .build();
    }
}
