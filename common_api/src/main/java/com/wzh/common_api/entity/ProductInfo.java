package com.wzh.common_api.entity;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ProductInfo implements Serializable {

      @Id
      private String productId;
      private String prodcutName;
      private double productPrice;
      private long productStock;
      private String productDescription;
      private String productIcon;
      private long categoryType;
      private Integer count;
      private Date createTime;
      private Date updateTime;

      @Override
      public String toString() {
            try {
                  return new ObjectMapper().writeValueAsString(this);
            } catch (JsonProcessingException e) {
                  e.printStackTrace();
                  return null;
            }
      }
}
