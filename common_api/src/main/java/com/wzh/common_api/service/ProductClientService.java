package com.wzh.common_api.service;

import com.wzh.common_api.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient("Taobao-product")
public interface ProductClientService {

    @GetMapping("/product/show")
    public Map<String,Object> showAll();

    @GetMapping("/product/one/{id}")
    public ProductInfo getOne(@PathVariable("id") String id);

    @PostMapping("/product/updateStore")
    public Map<String,Object> updateStore(ProductInfo productInfo);
}
