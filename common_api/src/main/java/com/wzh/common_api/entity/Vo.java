package com.wzh.common_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vo implements Serializable {
    private Map<String,ProductInfo> productInfoMap;

    public Map<String, ProductInfo> getProductInfoMap() {
        return productInfoMap;
    }

    public void setProductInfoMap(Map<String, ProductInfo> productInfoMap) {
        this.productInfoMap = productInfoMap;
    }
}
