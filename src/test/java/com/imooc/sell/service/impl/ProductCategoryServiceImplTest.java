package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findById() {
        Optional<ProductCategory> productCategory = productCategoryService.findById(1);
        Assert.assertNotEquals(false, productCategory.isPresent());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("男生专属", 8);
        ProductCategory result = productCategoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}