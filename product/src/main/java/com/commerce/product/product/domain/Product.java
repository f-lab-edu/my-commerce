package com.commerce.product.product.domain;

import com.commerce.product.common.aduit.BaseEntity;
import com.commerce.product.image.ImageDto;
import com.commerce.product.product.dto.CreateProduct;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private Long categoryId;
    private String name;
    private String description;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private List<Option> options = new ArrayList<>();

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private List<OptionCombination> optionCombinations = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> images = new ArrayList<>();

    public void addOption(Option option) {
        options.add(option);
    }

    public void addOptionCombination(OptionCombination optionCombination) {
        optionCombinations.add(optionCombination);
    }

    public void addProductImage(ProductImage image) {
        images.add(image);
        image.setProduct(this);
    }

    public static Product of(CreateProduct.Request productDto, List<ImageDto> images) {
        Product product = Product.builder()
                .name(productDto.getProductName())
                .categoryId(productDto.getCategoryId())
                .description(productDto.getDescription())
                .build();

        // 옵션 세팅
        productDto.getOptions()
                .forEach(o -> product.addOption(Option.of(o)));
        // 모든 옵션값 추출
        List<OptionValue> optionValueList = product.getOptions().stream()
                .flatMap(o -> o.getOptionValues().stream())
                .toList();
        // 옵션조합 세팅
        productDto.getOptionCombinations()
                .forEach(o -> product.addOptionCombination(OptionCombination.of(o, optionValueList)));
        // 이미지 세팅
        images.forEach(i -> product.addProductImage(ProductImage.of(i)));

        return product;
    }
}
