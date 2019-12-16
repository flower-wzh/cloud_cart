package com.wzh.provider_order_8003.service.impl;

import com.wzh.common_api.entity.OrderDetail;
import com.wzh.common_api.entity.OrderMaster;
import com.wzh.common_api.entity.ProductInfo;
import com.wzh.common_api.entity.Vo;
import com.wzh.provider_order_8003.dao.OrderDetailDao;
import com.wzh.provider_order_8003.dao.OrderMasterDao;
import com.wzh.provider_order_8003.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterDao orderMasterDao;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void insertOrder() {
        //获取购物车
        Map<String, ProductInfo> cart = new HashMap<>();
        Vo cartVo = (Vo) redisTemplate.opsForValue().get("cart");
        System.out.println(cartVo);
        if (cartVo != null) {
            cart = cartVo.getProductInfoMap();
            OrderMaster orderMaster = new OrderMaster();
            String id = UUID.randomUUID().toString().replace("-", "");
            orderMaster.setOrderId(id);
            orderMaster.setOrderAmount(cart.size());
            orderMaster.setBuyerAddress("郑州");
            orderMaster.setBuyerName("小王");
            orderMaster.setBuyerIphone("110");
            orderMaster.setBuyerOpenid("1");
            orderMaster.setOrderStatus(1);
            orderMaster.setPayStayus(0);
            orderMaster.setCreateTime(new Date());
            orderMaster.setUpdateTime(new Date());
            orderMasterDao.insertSelective(orderMaster);
            List<OrderDetail> orderDetailList = new ArrayList<>();
            cart.forEach(( k , v ) -> {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(id);
                orderDetail.setDetailId(UUID.randomUUID().toString().replace("-",""));
                orderDetail.setProductId(v.getProductId());
                orderDetail.setProdcutName(v.getProdcutName());
                orderDetail.setProductIcon(v.getProductIcon());
                orderDetail.setProductPrice(v.getProductPrice());
                orderDetail.setProductQuantity(v.getCount());
                orderDetail.setCreateTime(new Date());
                orderDetail.setUpdateTime(new Date());
            });
            orderDetailDao.insertList(orderDetailList);
        }
    }
}
