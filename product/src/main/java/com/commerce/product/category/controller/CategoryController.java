package com.commerce.product.category.controller;

import com.commerce.product.category.dto.CreateCategory;
import com.commerce.product.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CreateCategory.Response> createCategory(@RequestBody CreateCategory.Request request) {
        CreateCategory.Response response = categoryService.createCategory(request);
        return ResponseEntity.of(Optional.of(response));
    }
}
