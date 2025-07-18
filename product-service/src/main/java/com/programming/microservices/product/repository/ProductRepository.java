package com.programming.microservices.product.repository;

import com.programming.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String> {


}
