package com.wzh.provider_cart_8002.service;

import com.wzh.common_api.entity.ProductInfo;
import com.wzh.common_api.entity.Vo;
import com.wzh.common_api.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductClientService productClientService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Map<String, ProductInfo> showOrder() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Map<String,ProductInfo> cart = new HashMap<>();
        Vo cartVo = (Vo) valueOperations.get("cart");
        System.out.println(cartVo);
        if (cartVo != null) {
            cart = cartVo.getProductInfoMap();
        }
        return cart;
    }

    @Override
    public Map<String, Object> addToCart(String id) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Map<String,Object> map = new HashMap<>();
        Map<String, ProductInfo> cart = new HashMap<>();
        //取出购物车
        try {
            Vo cartVo = (Vo) valueOperations.get("cart");
            if (cartVo != null) {
                cart = cartVo.getProductInfoMap();
            }
            if(cart.containsKey(id)){
                cart.get(id).setCount(cart.get(id).getCount()+1);
            }else {
                ProductInfo data = productClientService.getOne(id);
                data.setCount(1);
                cart.put(id,data);
            }
            Vo vo = new Vo();
            vo.setProductInfoMap(cart);
            valueOperations.set("cart",vo);
            map.put("status",200);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",-200);
        }
        return map;
    }

    @Override
    public void clear() {
        redisTemplate.delete("cart");
    }
}
