package com.wzh.provider_order_8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.wzh.provider_product_8001.dao")
public class ProviderOrder8003Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderOrder8003Application.class, args);
    }

}
