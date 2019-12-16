package com.wzh.common_api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("Taobao-Order")
public interface OrderClientService {
    @RequestMapping("/add")
    public void add();

}
