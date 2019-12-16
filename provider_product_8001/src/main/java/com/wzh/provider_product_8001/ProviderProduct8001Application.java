package com.wzh.provider_product_8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.wzh.provider_product_8001.dao")
public class ProviderProduct8001Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderProduct8001Application.class, args);
    }

}
