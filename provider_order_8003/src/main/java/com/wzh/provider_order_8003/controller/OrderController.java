package com.wzh.provider_order_8003.controller;

import com.wzh.common_api.service.CartClientService;
import com.wzh.provider_order_8003.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartClientService cartClientService;

    @RequestMapping("/add")
    public void add() {
        orderService.insertOrder();
        cartClientService.clear();
    }
}
