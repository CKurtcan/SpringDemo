package com.CK.SpringDemo.repository;

import com.CK.SpringDemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductNameIgnoreCase(String productName);

    List<Product> findByProductNameContainsIgnoreCase(String productName);

    List<Product> findByProductPriceBetween(Double startPrice, Double endPrice);

    List<Product> findByProductUnitInStockGreaterThan(Integer minStockQuantity);

    List<Product> findByProductPriceGreaterThanEqual(Double price);

    Long countByProductCategory(String productCategory);

    Integer countByProductName(String productName);

    boolean existsByProductCategory(String productCategory);

    List<Product> findByProductCategoryIsNull();

    List<Product> findByProductCategoryStartingWith(char startChar);
}
