package com.wzh.consumer.controller;

import com.wzh.common_api.entity.ProductInfo;
import com.wzh.common_api.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductClientService productClientService;

    @GetMapping("/show")
    public Map<String, Object> showAll() {
        return productClientService.showAll();
    }

    @GetMapping("/one/{id}")
    public ProductInfo getOne(@PathVariable("id") String id) {
        return productClientService.getOne(id);
    }

    @PostMapping("/updateStore")
    public Map<String, Object> updateStore(ProductInfo productInfo) {
        return productClientService.updateStore(productInfo);
    }
}
