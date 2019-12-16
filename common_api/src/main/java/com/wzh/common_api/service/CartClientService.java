package com.wzh.common_api.service;

import com.wzh.common_api.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("Taobao-cart")
public interface CartClientService {

    @RequestMapping("/cart/show")
    public Map<String, ProductInfo> showOrder();

    @PostMapping("/cart/add/{id}")
    public Map<String,Object> addToCart(@RequestParam("id")@PathVariable("id") String id);

    @RequestMapping("/cart/clear")
    public void clear();
}
