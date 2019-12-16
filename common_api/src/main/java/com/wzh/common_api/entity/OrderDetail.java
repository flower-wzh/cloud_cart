package com.wzh.common_api.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderDetail implements Serializable {

  @Id
  private String detailId;
  private String orderId;
  private String productId;
  private String prodcutName;
  private double productPrice;
  private String productIcon;
  private long productQuantity;
  private Date createTime;
  private Date updateTime;

}
