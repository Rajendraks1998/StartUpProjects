package org.ramg.store.service.impl;

import org.modelmapper.ModelMapper;
import org.ramg.store.constants.ConstantsEnum;
import org.ramg.store.dto.ProductDto;
import org.ramg.store.entity.Product;
import org.ramg.store.exception.ResourceNotFoundException;
import org.ramg.store.repository.ProductRepository;
import org.ramg.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException(ConstantsEnum.PRODUCT_NOT_EXISTS.getValue()+productId)
        );
        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product) -> modelMapper.map(product,ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException(ConstantsEnum.PRODUCT_NOT_EXISTS.getValue() + productId)
        );
        productRepository.deleteById(productId);
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException(ConstantsEnum.PRODUCT_NOT_EXISTS.getValue()+ productId)
        );
        product.setName(updatedProduct.getName());
        product.setUser(updatedProduct.getUser());
        product.setQuantity(updatedProduct.getQuantity());
        product.setPrice(updatedProduct.getPrice());
        productRepository.save(product);
        return  modelMapper.map(product,ProductDto.class);
    }
}
