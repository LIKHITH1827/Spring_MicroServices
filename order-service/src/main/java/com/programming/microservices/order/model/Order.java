package com.programming.microservices.order.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.extern.java.Log;

import java.math.BigDecimal;

@Entity
@Table(name="t_orders")
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;



}
