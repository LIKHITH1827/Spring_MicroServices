package com.programming.microservices.product.controller;


import com.programming.microservices.product.dto.ProductRequestDTO;
import com.programming.microservices.product.dto.ProductResponseDTO;
import com.programming.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
            return   productService.createProduct(productRequestDTO);


    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDTO> getProducts() {
        return productService.getAllProducts();

    }


}
