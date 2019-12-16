package com.wzh.consumer.controller;

import com.wzh.common_api.entity.ProductInfo;
import com.wzh.common_api.service.CartClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartClientService cartClientService;

    @RequestMapping("/show")
    public Map<String, ProductInfo> showOrder() {
        Map<String, ProductInfo> stringProductInfoMap = cartClientService.showOrder();
        return stringProductInfoMap;
    }

    @PostMapping("/add/{id}")
    public Map<String, Object> addToCart(@PathVariable("id") String id) {
        return cartClientService.addToCart(id);
    }

    @RequestMapping("/clear")
    public void clear() {
        cartClientService.clear();
    }
}
