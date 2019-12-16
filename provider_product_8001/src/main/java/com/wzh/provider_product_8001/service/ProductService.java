package com.wzh.provider_product_8001.service;

import com.wzh.common_api.entity.ProductInfo;

import java.util.Map;

public interface ProductService {

    /**
     * 查找一个商品详情
     *
     * @param id
     * @return
     */
    ProductInfo findOneByProductId(String id);

    /**
     * 查找所有商品信息
     *
     * @return
     */
    Map<String, Object> findAllProduct();

    /**
     * 修改商品信息（库存）
     */
    Map<String, Object> updateProduct(ProductInfo productInfo);

}
