package com.wzh.provider_order_8003.dao;

import com.wzh.common_api.entity.OrderDetail;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface OrderDetailDao extends Mapper<OrderDetail>, IdListMapper<OrderDetail,String>, InsertListMapper<OrderDetail> {
}
