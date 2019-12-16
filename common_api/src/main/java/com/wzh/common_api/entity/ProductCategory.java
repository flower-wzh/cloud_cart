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
public class ProductCategory implements Serializable {

  @Id
  private String categoryId;
  private String categoryName;
  private long categoryType;
  private Date createTime;
  private Date updateTime;
  private List<ProductInfo> productInfos;

}
