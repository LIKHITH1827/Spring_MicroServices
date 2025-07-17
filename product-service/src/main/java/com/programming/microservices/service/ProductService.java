package com.programming.microservices.service;


import com.programming.microservices.dto.ProductRequestDTO;
import com.programming.microservices.dto.ProductResponseDTO;
import com.programming.microservices.model.Product;
import com.programming.microservices.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;

    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
         Product product = Product.builder()
                 .name(productRequestDTO.name())
                 .description(productRequestDTO.description())
                 .price(productRequestDTO.price())
                 .build();

         productRepository.save(product);

         log.info("Product created successfully");
         return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }


    public List<ProductResponseDTO> getAllProducts(){
        return productRepository.findAll().stream().map(product -> new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice())).collect(Collectors.toList());

    }

}
