package org.ramg.store.controller;

import org.ramg.store.dto.ProductDto;
import org.ramg.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@EnableMethodSecurity
@RequestMapping(value = "/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto product1 = productService.createProduct(productDto);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId){
        ProductDto productDto = productService.getProductById(productId);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProductById(productId);
        return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long productId, @RequestBody ProductDto updatedProduct){
        ProductDto productDto = productService.updateProduct(productId, updatedProduct);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProductDto>> getProductByUserId(@PathVariable("userId") Long userId){
        List<ProductDto> productDto = productService.getAllProductsByUserId(userId);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }


}
