package com.OnlineBookStore.OnlineBookStore.service;

import com.OnlineBookStore.OnlineBookStore.entity.ordersEntity;
import com.OnlineBookStore.OnlineBookStore.payload.ordersDto;

public interface ordersService {

    public ordersEntity createOrder(ordersDto orderDetails);
}
