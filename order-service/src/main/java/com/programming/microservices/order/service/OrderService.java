package com.programming.microservices.order.service;

import com.programming.microservices.order.dto.OrderRequestDTO;
import com.programming.microservices.order.model.Order;
import com.programming.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private  final OrderRepository orderRepository;

   public void placeOrder(OrderRequestDTO orderRequestDTO){
       Order order = Order.builder()
               .orderNumber(UUID.randomUUID().toString())
               .skuCode(orderRequestDTO.skuCode())
               .price(orderRequestDTO.price())
               .quantity(orderRequestDTO.quantity()).build();

       orderRepository.save(order);

  log.info("order placed : {}",orderRequestDTO);
   }


}
