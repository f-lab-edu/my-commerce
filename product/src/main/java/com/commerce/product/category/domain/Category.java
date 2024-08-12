package com.commerce.product.category.domain;

import com.commerce.product.category.dto.CreateCategory;
import com.commerce.product.category.type.CategoryStatus;
import com.commerce.product.common.aduit.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Category extends BaseEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double feeRate;
    private Long parentCategoryId;

    @Enumerated(value = EnumType.STRING)
    private CategoryStatus status;

    public static Category of(CreateCategory.Request request) {
        return Category.builder()
                .name(request.getName())
                .feeRate(request.getFeeRate())
                .parentCategoryId(request.getParentCategoryId())
                .build();
    }
}
