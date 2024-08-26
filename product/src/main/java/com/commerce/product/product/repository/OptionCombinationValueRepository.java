package com.commerce.product.product.repository;

import com.commerce.product.product.domain.OptionCombination;
import com.commerce.product.product.domain.OptionCombinationValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OptionCombinationValueRepository extends JpaRepository<OptionCombinationValue, Long> {

}
