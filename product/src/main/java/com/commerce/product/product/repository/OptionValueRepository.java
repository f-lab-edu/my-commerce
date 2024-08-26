package com.commerce.product.product.repository;

import com.commerce.product.product.domain.OptionValue;
import com.commerce.product.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OptionValueRepository extends JpaRepository<OptionValue, Long> {

}
