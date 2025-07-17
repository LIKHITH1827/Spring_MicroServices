package com.programming.microservices.repository;

import com.programming.microservices.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends MongoRepository<Product, String> {


}
