package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    Order save(Order order);
    List<Order> findAll();
    Optional<Order> findById(Long id);
    String generateOrderNumber();
    List<Order> findByUser(User user);
}
