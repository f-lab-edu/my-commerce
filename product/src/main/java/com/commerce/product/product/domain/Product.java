package com.commerce.product.product.domain;

import com.commerce.product.image.ImageDto;
import com.commerce.product.product.dto.CreateProduct;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private Long categoryId;
    private String description;

/*
    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OptionCombination> optionCombinations = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> images = new ArrayList<>();
*/
/*

    public static Product of(CreateProduct.Request request, List<ImageDto> images) {
        List<OptionValue> optionValueList = new ArrayList<>();

        List<Option> optionList = request.getOptions().stream()
                .map(o -> Option.of(o))
                .toList();

        optionList.forEach(o -> optionValueList.addAll(o.getOptionValues()));

        List<OptionCombination> optionCombinationList = request.getOptionCombinations().stream()
                .map(o -> OptionCombination.of(o, optionValueList))
                .toList();

        List<ProductImage> productImages = images.stream()
                .map(i -> ProductImage.of(i))
                .toList();

        //TODO: Images도 파일저장 확인하고 DB에 어떻게 할지 생각해야함

        return Product.builder()
                .name(request.getProductName())
                .categoryId(request.getCategoryId())
                .description(request.getDescription())
//                .options(optionList)
//                .optionCombinations(optionCombinationList)
//                .images(productImages)
                .build();
    }
*/

    public static Product of(CreateProduct.Request request) {
        return Product.builder()
                .name(request.getProductName())
                .categoryId(request.getCategoryId())
                .description(request.getDescription())
                .build();
    }
}
