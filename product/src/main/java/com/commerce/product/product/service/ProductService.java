package com.commerce.product.product.service;


import com.commerce.product.image.ImageDto;
import com.commerce.product.product.domain.*;
import com.commerce.product.product.dto.*;
import com.commerce.product.product.exception.ProductException;
import com.commerce.product.product.exception.ProductExceptionCode;
import com.commerce.product.product.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductImageRepository productImageRepository;

    private final ProductRepository productRepository;
    private final OptionRepository optionRepository;
    private final OptionValueRepository optionValueRepository;
    private final OptionCombinationRepository optionCombinationRepository;
    private final OptionCombinationValueRepository optionCombinationValueRepository;

/*    public CreateProduct.Response createProduct(CreateProduct.Request request, List<ImageDto> images) {
        if (productRepository.existsByName(request.getProductName())) {
            throw new ProductException(ProductExceptionCode.DUPLICATED_PRODUCT_NAME);
        }

        Product product = Product.of(request);

        List<Option> options = new ArrayList<>();

        for (CreateOption.Request createOption : request.getOptions()) {
            Option option = Option.of(createOption);
            List<OptionValue> optionValues = createOption.getOptionValues().stream()
                    .map(o -> OptionValue.of(o))
                    .toList();
            option.setOptionValues(optionValues);
            option.setProduct(product);
            options.add(option);
        }

        product.setOptions(options);


        List<CreateOptionCombination.Request> optionCombinations = request.getOptionCombinations();


        log.info(product.toString());

        return CreateProduct.Response.from(productRepository.save(product));
    }*/
/*
    public CreateProduct.Response createProduct(CreateProduct.Request request, List<ImageDto> images) {
        if (productRepository.existsByName(request.getProductName())) {
            throw new ProductException(ProductExceptionCode.DUPLICATED_PRODUCT_NAME);
        }

        Product product = Product.of(request);

        Map<String, OptionValue> optionValueMap = new HashMap<>();

        // 옵션
        for (CreateOption.Request createOption : request.getOptions()) {
            Option option = Option.of(createOption);
            option.setProduct(product);

            List<OptionValue> optionValues = createOption.getOptionValues().stream()
                    .map(o -> OptionValue.of(o))
                    .toList();

            optionValues.forEach(o -> o.setOption(option));

            option.setOptionValues(optionValues);
            product.getOptions().add(option);

            optionValues.forEach(o -> optionValueMap.put(o.getOptionValue(), o));
        }

        // 옵션조합
        for (CreateOptionCombination.Request createOptionCombination : request.getOptionCombinations()) {
            OptionCombination optionCombination = OptionCombination.of(createOptionCombination);
            optionCombination.setProduct(product);

            for (String value : createOptionCombination.getOptionCombinationValues()) {
                OptionValue optionValue = optionValueMap.get(value);
                if (Objects.isNull(optionValue)) {
                    throw new RuntimeException("잘못된 Value");
                }

                OptionCombinationValue ocv = OptionCombinationValue.of(optionCombination, optionValue);
                optionCombination.getValues().add(ocv);
                optionValue.getOptionCombinationValues().add(ocv);
            }

            product.getOptionCombinations().add(optionCombination);
        }

        log.info(product.toString());

        return CreateProduct.Response.from(productRepository.save(product));
    }*/

    public CreateProduct.Response createProduct(CreateProduct.Request request, List<ImageDto> images) {
        if (productRepository.existsByName(request.getProductName())) {
            throw new ProductException(ProductExceptionCode.DUPLICATED_PRODUCT_NAME);
        }

        Product product = Product.of(request);

        Product savedProduct = productRepository.save(product);

        Map<String, OptionValue> optionValueMap = new HashMap<>();

        // 옵션
        for (CreateOption.Request createOption : request.getOptions()) {
            Option option = Option.of(createOption);
            option.setProduct(product);

            optionRepository.save(option);

            List<OptionValue> optionValues = createOption.getOptionValues().stream()
                    .map(o -> OptionValue.of(o))
                    .toList();

            optionValues.forEach(o -> o.setOption(option));

            optionValueRepository.saveAll(optionValues);

            optionValues.forEach(o -> optionValueMap.put(o.getOptionValue(), o));
        }

        // 옵션조합
        for (CreateOptionCombination.Request createOptionCombination : request.getOptionCombinations()) {
            OptionCombination optionCombination = OptionCombination.of(createOptionCombination);
            optionCombination.setProduct(product);
            optionCombinationRepository.save(optionCombination);

            for (String value : createOptionCombination.getOptionCombinationValues()) {
                OptionValue optionValue = optionValueMap.get(value);
                if (Objects.isNull(optionValue)) {
                    throw new RuntimeException("잘못된 Value");
                }

                OptionCombinationValue ocv = OptionCombinationValue.of(optionCombination, optionValue);
                optionCombinationValueRepository.save(ocv);
            }
        }

        // 이미지
        List<ProductImage> productImages = images.stream()
                .map(i -> ProductImage.of(i))
                .toList();
        productImages.forEach(i -> i.setProduct(product));

        productImageRepository.saveAll(productImages);

        return CreateProduct.Response.from(savedProduct);
    }

    private OptionValue findOptionValue(String value, List<OptionValue> optionValueList) {
        for (OptionValue optionValue : optionValueList) {
            if (optionValue.getOptionValue().equals(value)) {
                return optionValue;
            }
        }

        return null;
    }

    public GetProductDetail.Response getProductDetail(Long productId) {
        // 검증
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_FOUND_PRODUCT));

        ProductDetailDto productDetailDto = ProductDetailDto.from(product);

        return GetProductDetail.Response.from(productDetailDto);
    }

    public UpdateProduct.Response updateProduct(UpdateProduct.Request request) {
//        productRepository.findById(request.get)


        return null; /*UpdateProduct.Response.from()*/
    }
}
