package com.wzh.provider_cart_8002.service;

import com.wzh.common_api.entity.ProductInfo;

import java.util.Map;

public interface CartService {

    Map<String, ProductInfo> showOrder();

    Map<String,Object> addToCart(String id);

    void clear();

}
