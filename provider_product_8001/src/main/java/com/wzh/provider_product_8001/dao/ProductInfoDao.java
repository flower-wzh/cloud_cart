package com.wzh.provider_product_8001.dao;

import com.wzh.common_api.entity.ProductCategory;
import com.wzh.common_api.entity.ProductInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductInfoDao extends Mapper<ProductInfo> {

    List<ProductCategory> findAllProducts();

}
