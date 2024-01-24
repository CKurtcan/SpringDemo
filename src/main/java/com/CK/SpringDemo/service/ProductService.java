package com.CK.SpringDemo.service;

import com.CK.SpringDemo.entity.Product;
import com.CK.SpringDemo.repository.ProductRepository;
import com.CK.SpringDemo.utility.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IService<Product,Long> {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(Product.builder()
                        .productName(product.getProductName())
                        .productCategory(product.getProductCategory())
                        .productPrice(product.getProductPrice())
                        .productUnitInStock(product.getProductUnitInStock())
                        .productDescription(product.getProductDescription())
                .build());
    }

    @Override
    public Product update(Product product) {
        Optional<Product> product1 = productRepository.findById(product.getId());
        if (product1.isPresent()){
            return productRepository.save(product);
        }else
            return null;
    }

    @Override
    public Iterable<Product> saveAll(Iterable<Product> t) {
        return null;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findByProductNameIgnoreCase(String productName) {
        return productRepository.findByProductNameIgnoreCase(productName);
    }

    @Override
    public List<Product> findByProductNameContainsIgnoreCase(String productName) {
        return productRepository.findByProductNameContainsIgnoreCase(productName);
    }

    @Override
    public List<Product> findByProductPriceBetween(Double startPrice, Double endPrice) {
        return productRepository.findByProductPriceBetween(startPrice, endPrice);
    }

    @Override
    public List<Product> findByProductUnitInStockGreaterThan(Integer minStockQuantity) {
        return productRepository.findByProductUnitInStockGreaterThan(minStockQuantity);
    }

    @Override
    public List<Product> findByProductPriceGreaterThanEqual(Double price) {
        return productRepository.findByProductPriceGreaterThanEqual(price);
    }

    @Override
    public Long countByProductCategory(String productCategory) {
        return productRepository.countByProductCategory(productCategory);
    }

    @Override
    public Integer countByProductName(String productName) {
        return productRepository.countByProductName(productName);
    }

    @Override
    public boolean existsByProductCategory(String productCategory) {
        if (productRepository.existsByProductCategory(productCategory))
            return true;
        else
            return true;
    }

    @Override
    public List<Product> findByProductCategoryIsNull() {
        return productRepository.findByProductCategoryIsNull();
    }

    @Override
    public List<Product> findByProductCategoryStartingWith(char startChar) {
        return productRepository.findByProductCategoryStartingWith(startChar);
    }
}
