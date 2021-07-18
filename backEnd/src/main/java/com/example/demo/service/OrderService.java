package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrderID(long id){
        return orderRepository.findByUserid(id);
    }

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }
}
