package com.imooc.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    /* 商品Id */
    private String productId;

    /* 数量 */
    private Integer productQuantity;
}
