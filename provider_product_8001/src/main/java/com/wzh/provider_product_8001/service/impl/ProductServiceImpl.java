package com.wzh.provider_product_8001.service.impl;

import com.wzh.common_api.entity.ProductCategory;
import com.wzh.common_api.entity.ProductInfo;
import com.wzh.provider_product_8001.dao.ProductInfoDao;
import com.wzh.provider_product_8001.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOneByProductId(String id) {
        return productInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> findAllProduct() {
        Map<String,Object> map = new HashMap<>();
        List<ProductCategory> allProduct = productInfoDao.findAllProducts();
        map.put("status",200);
        map.put("data",allProduct);
        return map;
    }

    @Override
    public Map<String, Object> updateProduct(ProductInfo productInfo) {
        Map<String,Object> map = new HashMap<>();
        productInfoDao.updateByPrimaryKeySelective(productInfo);
        map.put("status",200);
        map.put("data",productInfo);
        return map;
    }
}
