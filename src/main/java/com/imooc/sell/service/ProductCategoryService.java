package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {

    Optional<ProductCategory> findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
