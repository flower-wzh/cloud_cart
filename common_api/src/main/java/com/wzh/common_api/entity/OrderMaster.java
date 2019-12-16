package com.wzh.common_api.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderMaster implements Serializable {

  @Id
  private String orderId;
  private String buyerName;
  private String buyerIphone;
  private String buyerAddress;
  private String buyerOpenid;
  private double orderAmount;
  private long orderStatus;
  private long payStayus;
  private Date createTime;
  private Date updateTime;
  private List<OrderDetail> orderDetails;
}
