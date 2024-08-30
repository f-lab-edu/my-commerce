package com.commerce.product.product.repository;

import com.commerce.product.product.domain.OptionCombination;
import com.commerce.product.product.domain.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

}
