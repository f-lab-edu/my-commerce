package com.commerce.product.product.controller;

import com.commerce.product.image.ImageDto;
import com.commerce.product.image.ImageStore;
import com.commerce.product.product.dto.CreateProduct;
import com.commerce.product.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ImageStore imageStore;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestPart("info") CreateProduct.Request request,
                                           @RequestPart("imageFiles") List<MultipartFile> imageFiles) {
        log.info("상품 생성 - {}", request);

        List<ImageDto> images = imageStore.storeImage(imageFiles);
        CreateProduct.Response response = productService.createProduct(request, images);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<?> getProduct(@PathVariable("product-id") Long productId) {
        log.info("상품 상세 조회 - {}", productId);

        return ResponseEntity.ok(productService.findProduct(productId));
    }

}
