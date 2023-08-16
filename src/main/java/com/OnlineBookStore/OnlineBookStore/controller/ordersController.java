package com.OnlineBookStore.OnlineBookStore.controller;

import com.OnlineBookStore.OnlineBookStore.entity.ordersEntity;
import com.OnlineBookStore.OnlineBookStore.payload.ordersDto;
import com.OnlineBookStore.OnlineBookStore.serviceImpl.ordersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class ordersController {

    @Autowired
    private ordersImpl orderImpl;

    @PostMapping("/")
    public ResponseEntity<ordersEntity> placeOrder(@RequestBody ordersDto orderDetails){
        ordersEntity order = orderImpl.createOrder(orderDetails);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
