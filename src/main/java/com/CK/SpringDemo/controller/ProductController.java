package com.CK.SpringDemo.controller;

import com.CK.SpringDemo.entity.Product;
import com.CK.SpringDemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping("/save") // localhost:8080/product/save?productName=Samsung&productCategory=Phone&productPrice=1000&productUnitInStock=10&productDescription=SamsungPhone
    public Product save(Product product) {
        return productService.save(product);
    }
    @GetMapping("/find-all")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("find-by-id")
    public Optional<Product> findById(Long id) {
        return productService.findById(id);
    }
    @GetMapping("/update")
    public Product update(Product product) {
        return productService.update(product);
    }
    @GetMapping("/find-by-product-name")
    public Optional<Product> findByProductNameIgnoreCase(String productName) {
        return productService.findByProductNameIgnoreCase(productName);
    }
    @GetMapping("/find-by-product-name-contains")
    public List<Product> findByProductNameContainsIgnoreCase(String productName) {
        return productService.findByProductNameContainsIgnoreCase(productName);
    }
    @GetMapping("/find-by-price")
    public List<Product> findByProductPriceBetween(Double startPrice, Double endPrice) {
        return productService.findByProductPriceBetween(startPrice, endPrice);
    }
    @GetMapping("/find-by-price-greater")
    public List<Product> findByProductPriceGreaterThanEqual(Double price) {
        return productService.findByProductPriceGreaterThanEqual(price);
    }
    @GetMapping("/find-by-stock")
    public List<Product> findByProductUnitInStockGreaterThan(Integer minStockQuantity) {
        return productService.findByProductUnitInStockGreaterThan(minStockQuantity);
    }
    @GetMapping("/count-by-category")
    public Long countByProductCategory(String category) {
        return productService.countByProductCategory(category);
    }
    @GetMapping("/count-by-name")
    public Integer countByProductName(String productName) {
        return productService.countByProductName(productName);
    }
    @GetMapping("/check-category")
    public boolean existsByProductCategory(String category) {
        return productService.existsByProductCategory(category);
    }
    @GetMapping("/find-by-null-category")
    public List<Product> findByProductCategoryIsNull() {
        return productService.findByProductCategoryIsNull();
    }
    @GetMapping("/find-by-category-start")
    public List<Product> findByProductCategoryStartingWith(char startChar) {
        return productService.findByProductCategoryStartingWith(startChar);
    }
}
