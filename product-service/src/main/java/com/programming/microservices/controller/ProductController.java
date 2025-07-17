package com.programming.microservices.controller;


import com.programming.microservices.dto.ProductRequestDTO;
import com.programming.microservices.dto.ProductResponseDTO;
import com.programming.microservices.model.Product;
import com.programming.microservices.service.ProductService;
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
