package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductInfoStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findById() {
        Optional<ProductInfo> productInfo = productInfoService.findById("123456");
        Assert.assertTrue(productInfo.isPresent());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
//        productInfo.setProductId("123457");
//        productInfo.setProductName("皮皮虾");
//        productInfo.setProductPrice(new BigDecimal(3.2));
//        productInfo.setProductStock(100);
//        productInfo.setProductDescription("很好吃的虾！");
//        productInfo.setProductIcon("http://xxxxx.jpg");
//        productInfo.setProductStatus(ProductInfoStatusEnum.DOWN.getCode());
//        productInfo.setCategoryType(2);

        productInfo.setProductId("123458");
        productInfo.setProductName("芒果冰");
        productInfo.setProductPrice(new BigDecimal(20));
        productInfo.setProductStock(200);
        productInfo.setProductDescription("冰冰的很爽！");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductInfoStatusEnum.UP.getCode());
        productInfo.setCategoryType(3);

        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }
}