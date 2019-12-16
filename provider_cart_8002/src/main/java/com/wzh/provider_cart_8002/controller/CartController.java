package com.wzh.provider_cart_8002.controller;

import com.wzh.common_api.entity.ProductInfo;
import com.wzh.provider_cart_8002.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/show")
    public Map<String,ProductInfo> showOrder() {
        Map<String, ProductInfo> stringProductInfoMap = cartService.showOrder();
        System.out.println(stringProductInfoMap);
        return stringProductInfoMap;
    }

    @PostMapping("/add/{id}")
    public Map<String,Object> addToCart(@PathVariable("id") String id) {
        return cartService.addToCart(id);
    }

    @RequestMapping("/clear")
    public void clear() {
        cartService.clear();
    }

}
