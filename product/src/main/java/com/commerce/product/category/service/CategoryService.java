package com.commerce.product.category.service;

import com.commerce.product.category.domain.Category;
import com.commerce.product.category.dto.CreateCategory;
import com.commerce.product.category.exception.CategoryException;
import com.commerce.product.category.exception.CategoryExceptionCode;
import com.commerce.product.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;


    @Transactional
    public CreateCategory.Response createCategory(CreateCategory.Request request) {
        // 부모 카테고리 검증
        categoryRepository.findById(request.getParentCategoryId())
                .orElseThrow(() -> new CategoryException(CategoryExceptionCode.NOT_FOUND_CATEGORY));

        Category category = Category.of(request);

        return CreateCategory.Response.from(categoryRepository.save(category));
    }
}
