package com.CK.SpringDemo.utility;

import java.util.List;
import java.util.Optional;

public interface IService <T,ID> {

    T save(T t);
    T update(T t);
    Iterable<T> saveAll(Iterable<T> t);
    void delete(T t);
    void deleteById(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
    Optional<T> findByProductNameIgnoreCase(String productName);
    List<T> findByProductNameContainsIgnoreCase(String productName);
    List<T> findByProductPriceBetween(Double startPrice, Double endPrice);

    List<T> findByProductUnitInStockGreaterThan(Integer minStockQuantity);

    List<T> findByProductPriceGreaterThanEqual(Double price);

    Long countByProductCategory(String productCategory);

    Integer countByProductName(String productName);

    boolean existsByProductCategory(String productCategory);

    List<T> findByProductCategoryIsNull();

    List<T> findByProductCategoryStartingWith(char startChar);



}
