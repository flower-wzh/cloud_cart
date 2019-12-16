package com.wzh.consumer.controller;

import com.wzh.common_api.service.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderClientService orderClientService;

    @RequestMapping("/add")
    public void add() {
        orderClientService.add();
    }
}
