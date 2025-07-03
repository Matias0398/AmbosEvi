package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public String generateOrderNumber() {
        int number;
        String numeroConcatenado="";

        List<Order>orders=findAll();
        List<Integer>numbers= new ArrayList<>();

        orders.forEach(order ->numbers.add(Integer.parseInt(order.getNumber())));

        if(orders.isEmpty()) {
            number=1;
        }else {
            number=numbers.stream().max(Integer::compare).get();
            number++;
        }

        if(number<10) {
            numeroConcatenado="000000000"+ number;
        }else if(number<100) {
            numeroConcatenado="00000000"+ number;
        }else if(number<1000) {
            numeroConcatenado="0000000"+ number;
        }else if(number<10000) {
            numeroConcatenado="000000"+ number;
        }
        return numeroConcatenado;
    }

    @Override
    public List<Order> findByUser(User user) {
        return orderRepository.findByUser(user);
    }
}
