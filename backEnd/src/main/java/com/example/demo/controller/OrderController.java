package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getProduct(@RequestHeader("Authorization") long authId)
    {
            return orderService.getOrderID(authId);
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public Order addProduct(@RequestHeader("Authorization") long authId, @RequestBody Order order)
    {
        return orderService.addOrder(order);
    }
}
