package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void find() {
        Optional<ProductCategory> productCategory =  repository.findById(1);
        if (productCategory.isPresent()) {
            System.out.println(productCategory.get().toString());
        }
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("热销排行");
        productCategory.setCategoryType(5);

        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }

}