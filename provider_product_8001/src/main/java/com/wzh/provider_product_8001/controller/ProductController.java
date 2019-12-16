package com.wzh.provider_product_8001.controller;

import com.wzh.common_api.entity.ProductInfo;
import com.wzh.provider_product_8001.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/show")
    public Map<String,Object> showAll() {
        Map<String,Object> map = new HashMap<>();
        try {
            map = productService.findAllProduct();
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",-200);
            map.put("message",e.getMessage());
        }
        return map;
    }

    @GetMapping("/one/{id}")
    public ProductInfo getOne(@PathVariable("id") String id) {
        return productService.findOneByProductId(id);
    }

    @PostMapping("/updateStore")
    public Map<String,Object> updateStore(ProductInfo productInfo) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = productService.updateProduct(productInfo);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",-200);
            map.put("message",e.getMessage());
        }
        return map;
    }

}
