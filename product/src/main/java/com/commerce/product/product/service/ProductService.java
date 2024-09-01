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

    private final ProductRepository productRepository;

    @Transactional
    public CreateProduct.Response createProduct(CreateProduct.Request request, List<ImageDto> images) {
        if (productRepository.existsByName(request.getProductName())) {
            throw new ProductException(ProductExceptionCode.PRODUCT_DUPLICATED_NAME);
        }

        Product product = Product.of(request, images);

        return CreateProduct.Response.from(productRepository.save(product));
    }

    public GetProduct.Response findProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(ProductExceptionCode.PRODUCT_NOT_FOUND));

        return GetProduct.Response.from(product);
    }
}
