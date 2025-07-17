package com.programming.microservices.controller;


import com.programming.microservices.dto.ProductRequestDTO;
import com.programming.microservices.model.Product;
import com.programming.microservices.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
              productService.createProduct(productRequestDTO);


    }

}
