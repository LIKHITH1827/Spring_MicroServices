package com.programming.microservices.product.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(String id, String name, String description, BigDecimal price) {


}
