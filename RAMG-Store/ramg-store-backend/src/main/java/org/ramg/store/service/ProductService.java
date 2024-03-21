package org.ramg.store.service;

import org.ramg.store.dto.ProductDto;
import org.ramg.store.dto.UserDto;
import org.ramg.store.entity.Product;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductById(Long productId);
    List<ProductDto> getAllProducts();
    void deleteProductById(Long productId);
    ProductDto updateProduct(Long productId, ProductDto productDto);
    List<ProductDto> getProductsByUserId(Long userId);
    List<ProductDto> getProductsByUsername(String userName);

}
